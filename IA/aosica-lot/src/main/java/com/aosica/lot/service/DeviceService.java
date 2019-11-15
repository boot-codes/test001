package com.aosica.lot.service;


import com.aosica.common.bean.RequestResult;
import com.aosica.common.exception.AosicaServiceQueryException;
import com.aosica.common.exception.AosicaServiceSaveException;
import com.aosica.lot.dto.AgricultureDeviceDto;
import com.aosica.lot.dto.AgricultureDeviceMetricalInfoDto;
import com.aosica.lot.vo.AgricultureDeviceVo;

import java.util.List;
import java.util.Map;

/**
 *
 * @PackgeName com.aosica.lot.service
 * @ClassName DeviceService.java
 * @Description: TODO  设备管理模块
 * @Author: yuzp
 * @Date: 2019/9/11 15:38
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/11$ 15:38$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public interface DeviceService {


    /**
     * 添加单个设备
     * @return
     */
    void insertDevice(AgricultureDeviceDto equipmentDto) throws AosicaServiceSaveException;


    /**
     * 批量添加添加设备
     * @return
     */
    void batchInsertDevice(List<AgricultureDeviceMetricalInfoDto> list, long equipmentId) ;


    /**
     *  更新设备
     * @param equipmentDto
     */
    RequestResult updateDevice(AgricultureDeviceDto equipmentDto) ;


    /**
     * @description 查询设备详情信息
     * @param id
     * @param number
     * @return
     */
    AgricultureDeviceDto getDevice(long id, String number)  throws AosicaServiceQueryException;


    /**
     * @description 获取设备列表
     * @param map
     * @return
     */
    AgricultureDeviceVo listEquipment(Map<String, Object> map) throws AosicaServiceQueryException;


    /**
     * @description 获取设备不同状态下的数量
     * @param projectId
     * @param siteId
     * @return
     */
    Map<String, Object> listEquipment(String projectId,long siteId) throws AosicaServiceQueryException ;



}
