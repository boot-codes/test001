package com.aosica.lot.service;

import com.aosica.common.exception.AosicaServiceQueryException;
import com.aosica.common.exception.AosicaServiceSaveException;
import com.aosica.lot.entity.DeviceData;

/**
 * 智慧农业设备检测数据service
 * @PackgeName com.aosica.lot.service
 * @ClassName DeviceDataService.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/12 17:53
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/12$ 17:53$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public interface DeviceDataService {

    /**
     * 添加数据
     * @param deviceData
     */
    void save(DeviceData deviceData) throws AosicaServiceSaveException;


    /**
     * 获取 指定工程，指定网关id  设备最新的一条记录。
     * @return
     */
    DeviceData getNewestDeviceData(String projectId , String gateWayId) throws AosicaServiceQueryException;



}
