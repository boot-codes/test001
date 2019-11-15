package com.aosica.lot.service;


import com.aosica.lot.entity.WeatherDevice;

import java.util.List;

/** 气象设备数据接口
 * @PackgeName com.aosica.netty.service
 * @ClassName WeatherDeviceDataService.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/2 19:27
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/2$ 19:27$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public interface WeatherDeviceService {


    /**
     * 添加数据
     * @param
     * @return
     */
    int insert(WeatherDevice weatherDevice);



    /**
     *  Todo 功能描述 : 根据工程id 获取所有气象设备列表
     *
     * @param:
     * @return:
     * @auther: yuzp
     * @date: 2019/8/12 14:41
     */
    List<WeatherDevice> getWeatherDeviceDataList(String projectId) ;


}
