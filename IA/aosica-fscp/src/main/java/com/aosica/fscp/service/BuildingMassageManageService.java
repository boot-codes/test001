package com.aosica.fscp.service;


import com.aoscia.base.dto.BuildingDto;
import com.aoscia.base.dto.BuildingSecurityMassageDto;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.user.dto.BuildingResponsiblePersonDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public  interface BuildingMassageManageService {

    /**
     * 查看列表信息
     * @param dto :条件对象
     * @return
     */
    RequestResultPage<Page<BuildingDto>> selectList(BuildingDto dto);

    /**
     * 查看详情信息>>>>基本信息
     * @param id
     * @return
     */
    RequestResult selectDetailById(String id);

    /**
     * 查看详情信息>>>>管理信息
     * @param id
     * @return
     */
    RequestResult selectDetailToManageMassageById(String id);

    /**
     * 查看详情信息>>>>消防安全信息
     * @param id
     * @return
     */
    RequestResult selectDetailToFireSafeMassageById(String id);


    /**
     * 更新详情信息>>>>基本信息
     * @param dto
     * @return
     */
    RequestResult updateDetail(BuildingDto dto);

    /**
     * 更新详情信息>>>>管理信息
     * @param dtos
     * @return
     */
    RequestResult updateDetailToManageMassage(List<BuildingResponsiblePersonDto> dtos,String buildingId);

    /**
     * 更新详情信息>>>>消防安全信息
     * @param dto
     * @return
     */
    RequestResult updateDetailToFireSafeMassage(BuildingSecurityMassageDto dto );

    /**
     * 新增建筑物
     * @param dto
     * @return
     */
    RequestResult insert(BuildingDto dto);

    /**
     * 删除建筑物
     * @param id
     * @return
     */
    RequestResult remove(String id);
    /**
     * @desc 根据建筑物模糊名称查询建筑物列表
     * @param fuzzyName
     */
    RequestResult queryBuildIdAndNameListByFuzzyName(String fuzzyName);


    /**
     * @desc 根据建筑物id查询楼层信息
     * @param id
     */
    RequestResult queryFloorById(String id);
}
