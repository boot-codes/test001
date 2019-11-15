package com.aoscia.base.service;

import com.aoscia.base.dto.BuildingDto;
import com.aosica.common.bean.RequestResult;
import com.github.pagehelper.Page;

/**
 * @program: aosica-base->BuildingService
 * @description: 建筑物接口
 * @author: dwj
 * @create: 2019-09-24 10:10
 **/
public interface BuildingService{

    /**
     * @description 获取列表信息
     * @param dto
     */
    Page<BuildingDto> selectList(BuildingDto dto);

    /**
     * @description 获取详情信息
     * @param id
     */
    RequestResult<BuildingDto> selectDetailById(String id);


    /**
     * @description 新增信息
     * @param dto
     */
    RequestResult insert(BuildingDto dto);


    /**
     * @description 更新信息
     * @param dto
     */
    RequestResult update(BuildingDto dto);


    /**
     * @description 删除信息
     * @param id
     */
    RequestResult remove(String id);

}
