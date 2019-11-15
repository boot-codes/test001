package com.aosica.lot.mapper;


import com.aosica.lot.dto.DeviceSystemTypeQueryDTO;
import com.aosica.lot.entity.DeviceSystemType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 物联设备系统类型 mapper
 */
@Mapper
public interface DeviceSystemTypeMapper {


    /**
     *  添加数据
     * @param deviceSystemType
     * @return
     */
    int insert(DeviceSystemType deviceSystemType) ;


    /**
     * 根据查询对象查询数据
     * @param dto
     * @return
     */
    DeviceSystemType getByDtoCondition(@Param("dto") DeviceSystemTypeQueryDTO dto) ;


    /**
     * 查询所有的系统类型
     * @return
     */
    List<DeviceSystemType> getAllList() ;






    //    long countByExample(DeviceSystemTypeExample example);
//
//    int deleteByExample(DeviceSystemTypeExample example);
//
//    int deleteByPrimaryKey(Long id);
//

//
//    int insertSelective(DeviceSystemType record);
//
//    List<DeviceSystemType> selectByExample(DeviceSystemTypeExample example);
//
//    DeviceSystemType selectByPrimaryKey(Long id);
//
//    int updateByExampleSelective(@Param("record") DeviceSystemType record, @Param("example") DeviceSystemTypeExample example);
//
//    int updateByExample(@Param("record") DeviceSystemType record, @Param("example") DeviceSystemTypeExample example);
//
//    int updateByPrimaryKeySelective(DeviceSystemType record);
//
//    int updateByPrimaryKey(DeviceSystemType record);
}