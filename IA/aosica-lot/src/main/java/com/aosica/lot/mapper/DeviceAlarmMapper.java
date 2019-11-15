package com.aosica.lot.mapper;


import com.aosica.lot.entity.DeviceAlarm;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface DeviceAlarmMapper {


    /**
     * 添加数据
     * @param deviceAlarm
     * @return
     */
    int insert(DeviceAlarm deviceAlarm);


    /**
     * 根据id 更新
     * @param deviceAlarm
     * @return
     */
    int updateById(DeviceAlarm deviceAlarm);

//    int insertSelective(DeviceAlarm record);
//
//    List<DeviceAlarm> selectByExample(DeviceAlarmExample example);
//
//    DeviceAlarm selectByPrimaryKey(Long id);
//
//    int updateByExampleSelective(@Param("record") DeviceAlarm record, @Param("example") DeviceAlarmExample example);
//
//    int updateByExample(@Param("record") DeviceAlarm record, @Param("example") DeviceAlarmExample example);
//
//    int updateByPrimaryKeySelective(DeviceAlarm record);
//
//
//    long countByExample(DeviceAlarmExample example);
//
//    int deleteByExample(DeviceAlarmExample example);
//
//    int deleteByPrimaryKey(Long id);

}