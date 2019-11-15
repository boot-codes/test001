package com.aoscia.base.api;

import com.aoscia.base.dto.FireHydrantDto;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.github.pagehelper.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: aosica-base->FireHydrantServiceApi
 * @description: 消防栓对外接口
 * @author: dwj
 * @create: 2019-09-26 15:57
 **/
@RequestMapping("fireHydrant")
public interface FireHydrantServiceApi {

       /**
     * @description 获取消防栓列表
     * @param fireHydrantDto
     */
    @ApiOperation(value = "获取消防栓列表",notes = "")
    @ApiImplicitParam(dataTypeClass = FireHydrantDto.class)
    @RequestMapping(value = "selectList", method = RequestMethod.POST)
    RequestResultPage<Page<FireHydrantDto>> selectList(@RequestBody FireHydrantDto fireHydrantDto);

    /**
     * @description 获取消防栓列表详情信息
     * @param id
     */
    @ApiOperation(value = "获取消防栓列表详情信息",notes = "")
    @ApiImplicitParam(value = "id",name = "id")
    @RequestMapping(value = "selectDetailById", method = RequestMethod.POST)
    RequestResult selectDetailById(@RequestParam(value = "id")String id);

    /**
     * @description 新增或更新消防栓列表
     * @param fireHydrantDto
     */
    @ApiOperation(value = "新增或更新消防栓列表",notes = "")
    @ApiImplicitParam(dataTypeClass = FireHydrantDto.class)
    @RequestMapping(value = "saveAndUpdate", method = RequestMethod.POST)
    RequestResult saveAndUpdate(@RequestBody FireHydrantDto fireHydrantDto);

    /**
     * @description 删除消防栓
     * @param id
     */
    @ApiOperation(value = "删除消防栓",notes = "")
    @ApiImplicitParam(dataTypeClass = FireHydrantDto.class)
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    RequestResult remove(@RequestParam(value = "id") String id);
}
