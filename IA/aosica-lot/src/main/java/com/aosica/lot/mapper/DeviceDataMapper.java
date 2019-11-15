package com.aosica.lot.mapper;


import com.aosica.lot.entity.DeviceData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface DeviceDataMapper {

    /**
     * 添加检测的设备数据
     * @param deviceData
     * @return
     */
    int insert(DeviceData deviceData);


    /**
     * 获取 指定工程，指定网关id  设备最新的一条记录。
     * @param projectId
     * @param gateWayId
     * @return
     */
    DeviceData getNewestDeviceData(@Param("projectId") String projectId , @Param("gateWayId") String gateWayId) ;


    // long countByExample(TDeviceDataExample example);
//
//    int deleteByExample(TDeviceDataExample example);
//
//    int deleteByPrimaryKey(String id);


//    int insertSelective(TDeviceData record);

//    List<TDeviceData> selectByExample(TDeviceDataExample example);
//
//    TDeviceData selectByPrimaryKey(String id);
//
//    int updateByExampleSelective(@Param("record") TDeviceData record, @Param("example") TDeviceDataExample example);
//
//    int updateByExample(@Param("record") TDeviceData record, @Param("example") TDeviceDataExample example);
//
//    int updateByPrimaryKeySelective(TDeviceData record);
//
//    int updateByPrimaryKey(TDeviceData record);
}