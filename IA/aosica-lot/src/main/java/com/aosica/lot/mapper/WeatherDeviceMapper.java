package com.aosica.lot.mapper;


import com.aosica.lot.entity.WeatherDevice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 气象设备 mapper
 */
@Mapper
public interface WeatherDeviceMapper {


    /**
     * TODO 功能描述 : 添加数据
     * @param weatherDeviceData
     * @return
     */
    int insert(WeatherDevice weatherDeviceData);


    /**
     *  Todo 功能描述 : 根据工程id 获取所有气象设备列表
     * @param
     */
    List<WeatherDevice> getWeatherDeviceDataList(@Param("projectId") String projectId);

    //int insertSelective(WeatherDeviceData weatherDeviceData);


    /**
     * 根据id 删除
     * @param id
     * @return
     */
//    int deleteById(String id);


    /**
     * 根据查询条件查询
     * @param weatherDeviceData
     * @return
     */
//    List<WeatherDeviceData> selectByCondition(WeatherDeviceData weatherDeviceData);


    /**
     *  根据 id 查询
     * @param id
     * @return
     */
//    WeatherDeviceData selectById(String id);

    /**
     * 根据 id 更新。
     * @param weatherDeviceData
     * @return
     */
//    int update(WeatherDeviceData weatherDeviceData);
//
//    int updateByPrimaryKey(WeatherDeviceData weatherDeviceData);


    //    long countByExample(WeatherDeviceDataExample example);
//    int deleteByExample(TWeatherDeviceDataExample example);

    //    int updateByExampleSelective(@Param("record") WeatherDeviceData record, @Param("example") WeatherDeviceDataExample example);
//    int updateByExample(@Param("record") WeatherDeviceData record, @Param("example") WeatherDeviceDataExample example);

}