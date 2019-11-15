package com.aoscia.base.api;

import com.aoscia.base.dto.RescueTeamDto;
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
 * @program: aosica-base->RescueTeamServiceApi
 * @description: 救援队伍对外接口
 * @author: dwj
 * @create: 2019-09-26 15:57
 **/
@RequestMapping("rescueTeam")
public interface RescueTeamServiceApi {

    /**
     * @description 获取救援队伍列表
     * @param rescueTeamDto
     */
    @ApiOperation(value = "获取救援队伍列表",notes = "")
    @ApiImplicitParam(dataTypeClass = RescueTeamDto.class)
    @RequestMapping(value = "selectList", method = RequestMethod.POST)
    RequestResultPage<Page<RescueTeamDto>> selectList(@RequestBody RescueTeamDto rescueTeamDto);

    /**
     * @description 获取救援队伍详情信息
     * @param id
     */
    @ApiOperation(value = "获取救援队伍详情信息",notes = "")
    @ApiImplicitParam(value = "id",name = "id")
    @RequestMapping(value = "selectDetailById", method = RequestMethod.POST)
    RequestResult selectDetailById(@RequestParam(value = "id")String id);

    /**
     * @description 新增或更新救援队伍
     * @param rescueTeamDto
     */
    @ApiOperation(value = "新增或更新救援队伍",notes = "")
    @ApiImplicitParam(dataTypeClass = RescueTeamDto.class)
    @RequestMapping(value = "saveAndUpdate", method = RequestMethod.POST)
    RequestResult saveAndUpdate(@RequestBody RescueTeamDto rescueTeamDto);


    /**
     * @description 删除救援队伍
     * @param id
     */
    @ApiOperation(value = "删除救援队伍",notes = "")
    @ApiImplicitParam(dataTypeClass = RescueTeamDto.class)
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    RequestResult remove(@RequestParam(value = "id") String id);
}


