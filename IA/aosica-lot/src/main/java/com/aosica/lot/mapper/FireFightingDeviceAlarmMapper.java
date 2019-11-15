package com.aosica.lot.mapper;

import com.aosica.lot.dto.FireFightingDeviceAlarmDto;
import com.aosica.lot.dto.FireFightingDeviceAlarmQueryDto;
import com.aosica.lot.entity.FireFightingDeviceAlarm;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * 消防设备异常报警 mapper
 */
@Mapper
public interface FireFightingDeviceAlarmMapper {


    /**
     * 添加数据
     * @param fireFightingDeviceAlarm
     * @return
     */
    int insert(FireFightingDeviceAlarm fireFightingDeviceAlarm);


    /**
     * 查询设备的报警历史记录
     * @param dto
     * @return
     */
    Page<FireFightingDeviceAlarmDto> list(@Param("dto") FireFightingDeviceAlarmQueryDto dto) ;

//    int insertSelective(TFireFightingDeviceAlarm record);
//
//    List<TFireFightingDeviceAlarm> selectByExample(TFireFightingDeviceAlarmExample example);
//
//    TFireFightingDeviceAlarm selectByPrimaryKey(Long id);
//
//    int updateByExampleSelective(@Param("record") TFireFightingDeviceAlarm record, @Param("example") TFireFightingDeviceAlarmExample example);
//
//    int updateByExample(@Param("record") TFireFightingDeviceAlarm record, @Param("example") TFireFightingDeviceAlarmExample example);
//
//    int updateByPrimaryKeySelective(TFireFightingDeviceAlarm record);
//
//    int updateByPrimaryKey(TFireFightingDeviceAlarm record);

//    long countByExample(TFireFightingDeviceAlarmExample example);
//
//    int deleteByExample(TFireFightingDeviceAlarmExample example);
//
//    int deleteByPrimaryKey(Long id);

}