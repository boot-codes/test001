package com.aosica.fscp.controller;


import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.github.pagehelper.Page;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


/**
 * 信息管理通用接口模板
 *
 * */
public interface ManageControllerApi<T> {


    /**
     * 查看信息列表
     * @param dto:查询条件对象
     * @param bindingResult 页面参数错误信息
     * @return :返回列表数据
     * */
    @RequestMapping(value = "selectList", method = RequestMethod.POST)
    RequestResultPage<Page<T>> selectList(@RequestBody @Valid T dto, BindingResult bindingResult);

    /**
     *
     * @param dto :新增或更新对象(id为0,表示新增)
     * @param bindingResult 页面参数错误信息
     * @return 操作结果
     */
    @RequestMapping(value = "saveAndUpdate", method = RequestMethod.POST)
    RequestResult saveAndUpdate(@RequestBody @Valid T dto, BindingResult bindingResult);

    /**
     *
     * @param id
     * @return 操作结果
     */
    @RequestMapping(value = "/selectDetailById/{id}", method = RequestMethod.GET)
    RequestResult<T> selectDetailById(@PathVariable(value = "id") String id);

    /**
     *
     * @param id
     * @return 操作结果
     */
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    RequestResult remove(@PathVariable(value = "id") String id);

}
