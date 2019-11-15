package com.aoscia.base.api;

import com.aoscia.base.dto.FightingWaterDto;
import com.aosica.common.bean.RequestResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * @program: aosica-base->FightingWaterApi
 * @description: 消防水源对外接口
 * @author: dwj
 * @create: 2019-09-26 15:57
 **/
@RequestMapping("fightingWater")
public interface FightingWaterApi {

    /**
     * @description 获取消防水源列表
     * @param dto
     */
   @ApiOperation(value = "获取消防水源列表",notes = "")
    @ApiImplicitParam(dataTypeClass = FightingWaterDto.class)
    @RequestMapping(value = "selectList", method = RequestMethod.POST)
    RequestResult selectList(FightingWaterDto dto);

    @ApiOperation(value = "获取消防水源列表",notes = "")
    @ApiImplicitParam(dataTypeClass = FightingWaterDto.class)
    @RequestMapping(value = "list", method = RequestMethod.POST)
    RequestResult list(HashMap<String,Object> map);
    /**
     * @description 获取消防水源详情信息
     * @param id
     */
    @ApiOperation(value = "获取消防水源详细信息",notes = "")
    @ApiImplicitParam(value = "id",name = "id")
    @RequestMapping(value = "selectDetailById", method = RequestMethod.POST)
    RequestResult selectDetailById(@RequestParam(value = "id") String id);

    /**
     * @description 新增或更新消防水源
     * @param dto
     */
    @ApiOperation(value = "新增或更新消防水源",notes = "")
    @ApiImplicitParam(dataTypeClass = FightingWaterDto.class)
    @RequestMapping(value = "saveAndUpdate", method = RequestMethod.POST)
    RequestResult saveAndUpdate(@RequestBody FightingWaterDto dto);


    /**
     * @description 删除消防水源
     * @param id
     */
    @ApiOperation(value = "删除消防水源",notes = "")
    @ApiImplicitParam(dataTypeClass = FightingWaterDto.class)
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    RequestResult remove(@RequestParam(value = "id") String id);
}
