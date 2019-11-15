package com.aosica.lot.service.impl;

import com.aosica.common.exception.AosicaServiceQueryException;
import com.aosica.lot.dto.*;
import com.aosica.lot.entity.FireFightingDevice;
import com.aosica.lot.mapper.FireFightingDeviceMapper;
import com.aosica.lot.service.FireFightingDeviceService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackgeName com.aosica.lot.service.impl
 * @ClassName FireFightingDeviceServiceImpl.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/20 21:03
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/20$ 21:03$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@Service
public class FireFightingDeviceServiceImpl implements FireFightingDeviceService {



    @Autowired
    private FireFightingDeviceMapper mapper ;

//    @Autowired
//    private FireFightingDeviceAlarmMapper alarmMapper ;

    /**
     * 添加设备
     *
     * @param fireFightingDevice
     */
    @Override
    public void save(FireFightingDevice fireFightingDevice) {

        this.mapper.insert(fireFightingDevice) ;
    }

    /**
     * 根据查询对象，查询数据
     *
     * @param dto
     * @return
     */
    @Override
    public Page<DeviceSystemTypeDto> getListByCondition(FireFightingDeviceQueryDto dto) {
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize()) ;
        return this.mapper.getByCondition(dto);
    }



    /**
     * 按项目工程统计，统计某个工程下，设备系统的数据，设备的总数量，不正常的设备数量
     *
     * @param
     * @return
     */
    @Override
    public Page<DeviceSystemTypeNumStatisticsDTO> deviceStatueNumByProjectStatistics(DeviceStatisticsDto dto) {
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize()) ;
        return this.mapper.deviceStatueNumByProjectStatistics(dto);
    }



    /**
     * 物联监控数据统计--->设备实时状态数量统计
     *
     * @param deviceQueryDto
     * @return
     */
    @Override
    public List<DeviceStatueDto> deviceStatueCount(FireFightingDeviceQueryDto deviceQueryDto) throws AosicaServiceQueryException {
        return this.mapper.deviceStatueCount(deviceQueryDto);
    }

    /**
     * 按月统计 / 按年统计，异常设备的数量
     *
     * @param startDate
     * @param endDate
     */
    @Override
    public List<DeviceStatueDto> deviceStatueCountByMonthOrYear(FireFightingDeviceQueryDto deviceQueryDto, String startDate, String endDate,String type) throws AosicaServiceQueryException {
        if("year".equals(type)) {
            return this.mapper.deviceStatueCountByYear(deviceQueryDto, startDate, endDate);
        }
        else  {
            return this.mapper.deviceStatueCountByMonth(deviceQueryDto, startDate, endDate);
        }
    }



    /**
     * 根据建筑物id   获取该建筑物里的系统类型。
     *
     * @param projectId
     * @param buildingId
     */
    @Override
    public List<SystemTypeDTO> getSystemTypeByBuildId(String projectId, Long buildingId) {
        return  this.mapper.getSystemTypeByBuildId(projectId,buildingId) ;
    }


//    /**
//     * 设备异常报警记录 查询
//     *
//     * @param deviceQueryDto
//     * @return
//     */
//    @Override
//    public Page<DeviceAbnormalRecordDto> deviceAbnormalRecord(FireFightingDeviceQueryDto deviceQueryDto) throws AosicaServiceQueryException {
//        return  this.alarmMapper.list();
//    }



}
