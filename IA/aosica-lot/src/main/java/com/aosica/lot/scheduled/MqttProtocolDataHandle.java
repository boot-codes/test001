package com.aosica.lot.scheduled;

import com.aosica.common.exception.AosicaServiceSaveException;
import com.aosica.lot.dto.MqttProtocolDto;
import com.aosica.lot.entity.DeviceData;
import com.aosica.lot.service.DeviceDataService;
import com.aosica.lot.util.ObjectBuildFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *  Mqtt 协议数据处理组件。
 * @PackgeName com.aosica.lot.scheduled
 * @ClassName DataHandel.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/15 14:40
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/15$ 14:40$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
//@Async
//@Component
public class MqttProtocolDataHandle {

    /**
     * 用于接收保存设备发送过来的数据。根据 gateway id 作为key ,检测的数据用于 MqttProtocolDto 封装。\
     *  双层map
     *  第一层map: key->gateway id , value ->{key:设备id , value: MqttProtocolDto 设备数据}
     *  第二层map：key:设备id , value: MqttProtocolDto 设备数据
     */
    private Map<String, Map<String,MqttProtocolDto>> gateWayDeviceDataMap = new ConcurrentHashMap<>() ;


    @Autowired
    private DeviceDataService deviceDataService ;


    @PostConstruct
    public void init() {
        // 创建具有定时任务的，线程池
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        // 每隔 60*2=2 分钟执行一次。
        executorService.scheduleAtFixedRate(new DataHandelWorker(),60,120, TimeUnit.SECONDS) ;
        System.out.println("init mqtt data handle schedule  task .......");
    }


    /**
     * 添加数据
     * @param gateWayId
     * @param mqttProtocolDto
     */
    public void put(String gateWayId , MqttProtocolDto mqttProtocolDto) {

        System.out.println("\n\n networkDtoMap : " +gateWayDeviceDataMap);
        String id = mqttProtocolDto.getId();
        //获取同一个网关下的Map<String, MqttProtocolDto>对象
        Map<String, MqttProtocolDto> deviceDtoMap = gateWayDeviceDataMap.get(gateWayId);
        if(deviceDtoMap != null ) {
            deviceDtoMap.put(id,mqttProtocolDto) ;
        }
        else {
            deviceDtoMap = new HashMap<>() ;
            deviceDtoMap.put(id,mqttProtocolDto) ;
            gateWayDeviceDataMap.put(gateWayId, deviceDtoMap) ;
        }
    }


    class  DataHandelWorker implements Runnable {

        @Override
        public void run() {

            Map<String, Map<String,MqttProtocolDto>> persistenceDtoMap = new HashMap<>(gateWayDeviceDataMap)  ;
            System.out.println("开始执行定时体任务....................");

            //persinistMap = networkDtoMap ;
//            if(networkDtoMap != null) {
//                System.out.println("清除之前networkDtoMap：" +networkDtoMap);
//                networkDtoMap.clear();
//                System.out.println("清除之后networkDtoMap："+networkDtoMap);
//            }

            if(persistenceDtoMap == null || persistenceDtoMap.size() ==0) {
                System.out.println(" **** 检测到 : persinistMap == null ");
                return;
            }

            DeviceData deviceData = new DeviceData() ;

            Iterator<String> gateWayIdKeyIterator = persistenceDtoMap.keySet().iterator() ;

            while (gateWayIdKeyIterator.hasNext()) {
                String key = gateWayIdKeyIterator.next();
                Map<String, MqttProtocolDto> mqttDtoMap = persistenceDtoMap.get(key);

                Iterator<String> subKeysIterator = mqttDtoMap.keySet().iterator();
                while (subKeysIterator.hasNext()) {
                    String subKey = subKeysIterator.next();
                    MqttProtocolDto subDto = mqttDtoMap.get(subKey) ;
                    ObjectBuildFactory.deviceDataObject(deviceData ,subDto) ;
                }
            }

            System.out.println("=====> 最终组装的对象:" +deviceData);

            try {
                deviceDataService.save(deviceData);
            }
            catch (AosicaServiceSaveException e) {
                e.printStackTrace();
            }

            if(persistenceDtoMap != null && persistenceDtoMap.size() >0) {
                persistenceDtoMap.clear();
                persistenceDtoMap = null ;
            }

        }
    }


}
