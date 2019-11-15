package com.aoscia.base.mapper;

import com.aoscia.base.dto.BuildingImportantPartEntity;
import com.aoscia.base.dto.BuildingSecurityMassageDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: aosica-base->BuildIngService
 * @description: 楼栋接口
 * @author: ylp
 * @create: 2019-08-21 19:05
 **/
@Mapper
public interface BuildingSecurityMassageMapper {


    /**
     * @desc 根据建筑物id获取当前建筑物的消防安全信息
     * @param buildingId
     * @return BuildingSecurityMassageDto
     */
    BuildingSecurityMassageDto queryBuildingSecurityMassageByBuildingId(@Param(value = "buildingId") String buildingId);

    /**
     * @desc 更新消防安全信息
     * @param dto
     * @return
     */
    void update(BuildingSecurityMassageDto dto);

    /**
     * @desc 新增消防安全信息
     * @param dto
     */
   // void insert(BuildingSecurityMassageDto dto);
   //消防安全信息位于建筑物表中,其新增和删除与建筑物表保持一致


    /**
     * @desc 根据建筑物id查询消防重点部位
     * @param buildingId
     */
    List<BuildingImportantPartEntity> queryImportantPartByBuildingId (@Param(value = "buildingId") String buildingId);

    /**
     * @desc 新增重点部位信息
     * @param dto
     */
    void insertImportantPart (BuildingImportantPartEntity  dto);

    /**
     * @desc 更新重点部位信息
     * @param dto
     */
    void updateImportantPart (BuildingImportantPartEntity  dto);


    /**
     * @desc 删除重点部位信息
     * @param importantPartId
     */
    void removeBuildingImportantPart (@Param(value = "importantPartId") String importantPartId);
}
