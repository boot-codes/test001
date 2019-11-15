package com.aosica.lot.service.impl;

import com.aosica.common.exception.AosicaServiceQueryException;
import com.aosica.common.exception.AosicaServiceSaveException;
import com.aosica.lot.entity.DeviceData;
import com.aosica.lot.mapper.DeviceDataMapper;
import com.aosica.lot.service.DeviceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PackgeName com.aosica.lot.service.impl
 * @ClassName DeviceDataServiceImpl.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/12 17:54
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/12$ 17:54$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@Service
public class DeviceDataServiceImpl implements DeviceDataService {


    @Autowired
    private DeviceDataMapper deviceDataMapper ;


    /**
     * 添加数据
     *
     * @param deviceData
     */
    @Override
    public void save(DeviceData deviceData) throws AosicaServiceSaveException {
        this.deviceDataMapper.insert(deviceData) ;
    }



    /**
     * 获取 指定工程，指定网关id  设备最新的一条记录。
     *
     * @param projectId
     * @param gateWayId
     * @return
     */
    @Override
    public DeviceData getNewestDeviceData(String projectId , String gateWayId) throws AosicaServiceQueryException {
        return  this.deviceDataMapper.getNewestDeviceData(projectId, gateWayId) ;
    }




}
