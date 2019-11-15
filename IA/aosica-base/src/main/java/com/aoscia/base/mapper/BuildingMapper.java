package com.aoscia.base.mapper;

import com.aoscia.base.dto.BuildingDto;
import com.aoscia.base.entity.SafetyBuildingManagerEntity;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: aosica-base->BuildIngService
 * @description: 楼栋接口
 * @author: ylp
 * @create: 2019-08-21 19:05
 **/
@Mapper
public interface BuildingMapper {


    /**
     * @desc 获取当前项目下建筑物
     * @param buildingDto
     * @return List<BuildingDto>
     */
    Page<BuildingDto> queryList(BuildingDto buildingDto);

    /**
     * @desc 获取建筑物下的管理人员
     * @param buildingId
     * @return
     */
    List<SafetyBuildingManagerEntity> queryBuildingManager(@RequestParam(value = "buildingId") String buildingId);
    /**
     * @desc 获取当前项目下建筑物数量
     * @param buildingDto
     * @return
     */
  /*  int queryCount(BuildingDto buildingDto);*/

    /**
     * @desc 新增建筑物
     * @param buildingDto
     */
    void insert(BuildingDto buildingDto);

    /**
     * @desc 修改建筑物
     * @param buildingDto
     */
    void update(BuildingDto buildingDto);

    /**
     * @desc 查看建筑物详情信息
     * @param id
     * @return
     */
    BuildingDto queryById(@RequestParam(value = "id") String id);

    /**
     * @desc 删除建筑物
     * @param id
     */
    void remove(@RequestParam(value = "id") String id);

}
