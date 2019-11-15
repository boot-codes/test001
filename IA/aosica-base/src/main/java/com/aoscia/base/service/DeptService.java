package com.aoscia.base.service;

import com.aoscia.base.dto.DeptDto;
import com.aosica.common.bean.RequestResult;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: aosica-base->DeptService
 * @description: 机构接口
 * @author: dwj
 * @create: 2019-09-24 10:10
 **/
public interface DeptService {

    /**
     * @desc 查询机构信息
     * @param projectId
     */
    RequestResult selectList(@RequestParam(value = "projectId") String projectId);


    /**
     * @desc 新增机构信息
     */
    RequestResult save(DeptDto deptDto);
}
