package com.aoscia.base.service;

import com.aosica.common.bean.RequestResult;
import com.github.pagehelper.Page;

public interface ManageService<T> {

    /**
     * @description 获取列表信息
     * @param dto
     */
    Page<T> selectList(T dto);

    /**
     * @description 获取详情信息
     * @param id
     */
    RequestResult<T> selectDetailById(String id);

    /**
     * @description 新增或更新信息
     * @param dto
     */
    RequestResult saveAndUpdate(T dto);


    /**
     * @description 删除信息
     * @param id
     */
    RequestResult remove(String id);
}
