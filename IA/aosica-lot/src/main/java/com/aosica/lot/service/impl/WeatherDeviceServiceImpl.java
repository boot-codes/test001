package com.aosica.lot.service.impl;


import com.aosica.common.config.IdWorker;
import com.aosica.lot.entity.WeatherDevice;
import com.aosica.lot.mapper.WeatherDeviceMapper;
import com.aosica.lot.service.WeatherDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *  气象设备数据
 * @PackgeName com.aosica.netty.service.impl
 * @ClassName WeatherDeviceDataServiceImpl.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/2 19:29
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/2$ 19:29$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@Service
public class WeatherDeviceServiceImpl implements WeatherDeviceService {


    @Autowired
    private WeatherDeviceMapper weatherDeviceDataMapper ;


    /**
     * 添加气象五元素数据
     * @param
     * @return
     */
    @Override
    public int insert(WeatherDevice weatherDevice) {

        weatherDevice.setId(String.valueOf(String.valueOf(IdWorker.generateId())));
        // 工程id
        weatherDevice.setProjectId("10000");
        System.out.println("insert =>" +weatherDevice);
        // 设备型号
        weatherDevice.setDeviceModel("苏颂WS-5P");
        // 设备id
        weatherDevice.setDeviceId("324041514078044220");
        weatherDevice.setRemark("HQ-WS-5P同时实时监测风速、风向、温度、湿度、气压");
        return this.weatherDeviceDataMapper.insert(weatherDevice);
    }

    /**
     * Todo 功能描述 : 根据工程id 获取所有气象设备列表
     *
     * @param projectId
     * @param:
     * @return:
     * @auther: yuzp
     * @date: 2019/8/12 14:41
     */
    @Override
    public List<WeatherDevice> getWeatherDeviceDataList(String projectId) {
        return this.weatherDeviceDataMapper.getWeatherDeviceDataList(projectId);
    }


}
