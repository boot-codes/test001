package com.aosica.lot.mapper;


import com.aosica.lot.dto.*;
import com.aosica.lot.entity.FireFightingDevice;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 消防物防设备 mapper
 */

@Mapper
public interface FireFightingDeviceMapper {


    /**
     * 添加设备
     * @param fireFightingDevice
     * @return
     */
    int insert(FireFightingDevice fireFightingDevice);


    /**
     * 根据查询对象，查询数据
     * @param dto
     * @return
     */
    Page<DeviceSystemTypeDto> getByCondition(@Param("dto") FireFightingDeviceQueryDto dto);


    /**
     * 按项目工程统计，统计某个工程下，设备系统的数据，设备的总数量，不正常的设备数量
     * @param
     */
    Page<DeviceSystemTypeNumStatisticsDTO> deviceStatueNumByProjectStatistics(@Param("dto") DeviceStatisticsDto dto) ;


    /**
     * 物联监控数据统计--->设备状态数量统计
     * @return
     */
    List<DeviceStatueDto> deviceStatueCount(@Param("dto") FireFightingDeviceQueryDto dto) ;



    /**
     * 按月统计，异常设备的数量
     */
    List<DeviceStatueDto> deviceStatueCountByMonth(@Param("dto") FireFightingDeviceQueryDto dto
                                                   ,@Param("startDate") String startDate
                                                   ,@Param("endDate") String endDate) ;


    /**
     * 按年统计，异常设备的数量
     */
    List<DeviceStatueDto> deviceStatueCountByYear(@Param("dto") FireFightingDeviceQueryDto dto
                                                 ,@Param("startDate") String startDate
                                                 ,@Param("endDate") String endDate) ;


    /**
     * 根据建筑物 ，获取该建筑物下的所有系统类型。
     * @param projectId
     * @param buildingId
     * @return
     */
    List<SystemTypeDTO> getSystemTypeByBuildId(@Param("projectId") String projectId, @Param("buildingId") Long buildingId) ;

    /**
     * 设备异常报警记录 查询
     *
     * @param dto
     * @return
     */
//    Page<DeviceAbnormalRecordDto> deviceAbnormalRecord(@Param("dto") FireFightingDeviceQueryDto dto) ;

}