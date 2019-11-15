package com.aosica.lot.protocol.mqtt;

import com.aosica.common.util.DateUtil;
import com.aosica.common.util.JsonUtil;
import com.aosica.lot.dto.MqttProtocolDto;
import com.aosica.lot.scheduled.MqttProtocolDataHandle;
import com.aosica.lot.service.DeviceDataService;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/** 
 * 接收 【订阅主题】 的消息类。
 *
 * 
 */
public class SubscribeCallback implements MqttCallback {

    private DeviceDataService deviceDataService ;

    private MqttProtocolDataHandle dataHandle ;

    public SubscribeCallback(DeviceDataService deviceDataService , MqttProtocolDataHandle dataHandle) {
        this.deviceDataService = deviceDataService ;
        this.dataHandle = dataHandle ;
    }

    /**
     * 接收订阅消息的处理方法。
     * @param topic
     * @param message
     * @throws Exception
     */
    public void messageArrived(String topic, MqttMessage message) throws Exception {  
        // subscribe后得到的消息会执行到这里面

        System.out.println("接收消息主题 : " + topic);  
        System.out.println("接收消息Qos : " + message.getQos());  
        System.out.println("接收消息内容 : " + new String(message.getPayload()));
        System.out.println("接收时间:"+ DateUtil.getCurrentDate(DateUtil.YMD24H_DATA));
        System.out.println("是否是实时的数据：" +message.isRetained());
//        System.out.println("id :" +message.getId());
//        System.out.println(JSON.toJSON(message));


//        if("stds/down/sys/".startsWith(topic)) {
//            String mesg = new String(message.getPayload());
//            if("{\"refresh\":1}".equalsIgnoreCase(mesg)) {
//
//            }
//        }
        // 智慧农业项目
        if(topic.startsWith("stds/up/CL/")) {
            MqttProtocolDto mqttProtocolDto = JsonUtil.jsonToPojo(new String(message.getPayload()),MqttProtocolDto.class) ;
            String[] arrays = topic.split("stds/up/CL/");
            mqttProtocolDto.setGateWayId(arrays[1]);
            this.dataHandle.put(arrays[1],mqttProtocolDto);
        }
        else if("tdtu".equals(topic)) {

            //设备普通数据上报（5分钟一次），发tdtu这个topic
            // 报警数据上报，实时上报，发tdtu这个topic。
        }
        else if("tgetpare".equals(topic)) {
            //设备信息上报 联网成功发一次，其余400分钟发一次，发tgetpare这个topic。
        }
        else if("rgetpare".equals(topic)) {

        }
//        tdtu
//         tgetpare
//        rgetpare
        else {

        }
    }

    /**
     * 连接丢失后，在这里面进行重连
     * @param cause
     */
    public void connectionLost(Throwable cause) {
        System.out.println("连接断开，可以做重连");
        cause.printStackTrace();
    }


    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("deliveryComplete---------" + token.isComplete());
    }


}  
