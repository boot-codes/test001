package com.aoscia.base.api;

import com.aoscia.base.dto.LawEnforcementTeamDto;
import com.aosica.common.bean.RequestResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: aosica-base->LawEnforcementServiceTeamApi
 * @description: 执法队伍对外接口
 * @author: dwj
 * @create: 2019-09-26 15:57
 **/
@RequestMapping("lawEnforcementTeam")
public interface LawEnforcementServiceTeamApi {

    /**
     * @description 获取救援队伍列表
     * @param lawEnforcementTeamDto
     */
    @ApiOperation(value = "获取救援队伍列表",notes = "")
    @ApiImplicitParam(dataTypeClass = LawEnforcementTeamDto.class)
    @PostMapping("selectList")
    RequestResult selectList(LawEnforcementTeamDto lawEnforcementTeamDto);

    /**
     * @description 获取救援队伍详情信息
     * @param id
     */
    @ApiOperation(value = "获取救援队伍详情信息",notes = "")
    @ApiImplicitParam(value = "id",name = "id")
    @PostMapping("selectDetailById")
    RequestResult selectDetailById(@RequestParam(value = "id")String id);

    /**
     * @description 新增救援队伍
     * @param lawEnforcementTeamDto
     */
    @ApiOperation(value = "新增救援队伍",notes = "")
    @ApiImplicitParam(dataTypeClass = LawEnforcementTeamDto.class)
    @PostMapping("save")
    RequestResult saveAndUpdate(LawEnforcementTeamDto lawEnforcementTeamDto);
}
