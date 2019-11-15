package com.aosica.lot.service;

import com.aosica.common.exception.AosicaServiceQueryException;
import com.aosica.common.exception.AosicaServiceSaveException;
import com.aosica.lot.dto.*;
import com.aosica.lot.entity.FireFightingDevice;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @PackgeName com.aosica.lot.service
 * @ClassName FireFightingDeviceService.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/20 20:33
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/20$ 20:33$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public interface FireFightingDeviceService {


    /**
     * 添加设备
     * @param fireFightingDevice
     */
    void save(FireFightingDevice fireFightingDevice) throws AosicaServiceSaveException ;


    /**
     * 根据查询对象，查询数据
     * @param dto
     * @return
     */
    Page<DeviceSystemTypeDto> getListByCondition(FireFightingDeviceQueryDto dto) throws AosicaServiceQueryException ;


    /**
     *  设备视角 (根据系统类型统计，设备系统的数据，设备的总数量，不正常的设备数量)
     *  按项目工程统计，统计某个工程下，设备系统的数据，设备的总数量，不正常的设备数量
     * @param
     * @return
     */
    Page<DeviceSystemTypeNumStatisticsDTO> deviceStatueNumByProjectStatistics(DeviceStatisticsDto dto) throws AosicaServiceQueryException ;



    /**
     * 物联监控数据统计--->设备实时状态数量统计
     * @return
     */
    List<DeviceStatueDto> deviceStatueCount(FireFightingDeviceQueryDto deviceQueryDto) throws AosicaServiceQueryException;


    /**
     * 按月统计 / 按年统计，异常设备的数量
     *
     */
    List<DeviceStatueDto> deviceStatueCountByMonthOrYear(FireFightingDeviceQueryDto deviceQueryDto, String startDate, String endDate,String type) throws AosicaServiceQueryException;


    /**
     *  根据建筑物id   获取该建筑物里的系统类型。
     */
    List<SystemTypeDTO> getSystemTypeByBuildId(String projectId , Long buildingId) ;

}
