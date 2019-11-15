package com.aosica.lot.util;


import com.aosica.common.config.IdWorker;
import com.aosica.lot.dto.MqttProtocolDto;
import com.aosica.lot.dto.WeatherDeviceDataDTO;
import com.aosica.lot.entity.DeviceData;
import com.aosica.lot.entity.WeatherDevice;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @PackgeName com.aosica.netty.util
 * @ClassName ObjecctBuildFactory.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/2 19:45
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/2$ 19:45$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public final class ObjectBuildFactory {


    /**
     *  构建 WeatherDeviceData 对象
     * @param weatherDeviceDataDTO
     * @return
     */
    public static WeatherDevice weatherDeviceDataObject(WeatherDeviceDataDTO weatherDeviceDataDTO)  {

        WeatherDevice weatherDeviceData = new WeatherDevice() ;

        try {
            org.apache.commons.beanutils.BeanUtils.copyProperties(weatherDeviceData,weatherDeviceDataDTO);
            //weatherDeviceData.setId("111111111111");
            weatherDeviceData.setCollectorDate(new Date());
            //weatherDeviceData.setProjectId("10000");
            return weatherDeviceData ;
        }
        catch (Exception e) {
            e.printStackTrace();
            return  null ;
        }
    }


    public static DeviceData deviceDataObject(MqttProtocolDto mqttProtocolDto)  {

        DeviceData deviceData = new DeviceData() ;

        try {
            org.apache.commons.beanutils.BeanUtils.copyProperties(deviceData,mqttProtocolDto);
            deviceData.setId(IdWorker.generateId());
            deviceData.setGatewayId(mqttProtocolDto.getGateWayId());
            deviceData.setDeviceId(mqttProtocolDto.getId());
            deviceData.setProjectId("10000");
            deviceData.setCreateTime(new Date());
            return deviceData ;
        }
        catch (Exception e) {
            e.printStackTrace();
            return  null ;
        }
    }

    public static void  deviceDataObject(DeviceData deviceData ,MqttProtocolDto mqttProtocolDto)  {


        try {
            //org.apache.commons.beanutils.BeanUtils.copyProperties(deviceData,mqttProtocolDto);

            if(mqttProtocolDto.getWindS() !=0) {
                deviceData.setWinds(mqttProtocolDto.getWindS());
                deviceData.setWinds(deviceData.getWinds());
            }

            if(mqttProtocolDto.getWindD() !=0) {
                deviceData.setWindD(mqttProtocolDto.getWindD());
                deviceData.setWindD(deviceData.getWindD());
            }

            if(mqttProtocolDto.getAirH() !=0) {
                deviceData.setAirH(mqttProtocolDto.getAirH());
                deviceData.setAirH(deviceData.getAirH());
            }

            if(mqttProtocolDto.getAirT() !=0) {
                deviceData.setAirT(mqttProtocolDto.getAirT());
                deviceData.setAirT(deviceData.getAirT());
            }

            if(mqttProtocolDto.getIll() !=0) {
                deviceData.setIll(mqttProtocolDto.getIll());
            }

            if(mqttProtocolDto.getAtm() !=0) {
                deviceData.setAtm(mqttProtocolDto.getAtm());
            }

            if(mqttProtocolDto.getRainF() !=0) {
                deviceData.setRainF(mqttProtocolDto.getRainF());
            }
            if(mqttProtocolDto.getSoilH() !=0) {
                deviceData.setSoilH(mqttProtocolDto.getSoilH());
            }

            if(mqttProtocolDto.getSoilT() !=0) {
                deviceData.setSoilT(mqttProtocolDto.getSoilT());
            }
            if(mqttProtocolDto.getSoilC() !=0) {
                deviceData.setSoilC(mqttProtocolDto.getSoilC());
            }
            if(mqttProtocolDto.getSoilS() !=0) {
                deviceData.setSoilS(mqttProtocolDto.getSoilS());
            }

            if(mqttProtocolDto.getdPH() !=0) {
                deviceData.setdPH(mqttProtocolDto.getdPH());
            }


            deviceData.setId(IdWorker.generateId());
            deviceData.setGatewayId(mqttProtocolDto.getGateWayId());
            String deviceId = deviceData.getDeviceId();
            if(StringUtils.isNotBlank(deviceId) ) {
                if("6".equals(mqttProtocolDto.getId())) {
                    deviceId += mqttProtocolDto.getId() ;
                }
                else {
                    deviceId += mqttProtocolDto.getId() + ",";
                }
                deviceData.setDeviceId(deviceId);
            }
            else {
                deviceData.setDeviceId(mqttProtocolDto.getId()+",");
            }

            deviceData.setProjectId("10000");
            deviceData.setCreateTime(new Date());

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }









}
