package com.aoscia.base.api;

import com.aoscia.base.dto.BuildingSecurityMassageDto;
import com.aosica.common.bean.RequestResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("buildingSecurityMassage")
public interface BuildingSecurityMassageServiceApi {

    @ApiOperation(value = "根据建筑物id获取当前建筑物的消防安全信息",notes = "")
    @ApiImplicitParam(dataTypeClass = BuildingSecurityMassageDto.class)
    @RequestMapping(value = "queryBuildingSecurityMassageByBuildingId/{buildingId}", method = RequestMethod.POST)
    RequestResult<BuildingSecurityMassageDto> queryBuildingSecurityMassageByBuildingId(@PathVariable("buildingId") String buildingId);



    @ApiOperation(value = "更新消防安全信息",notes = "")
    @ApiImplicitParam(dataTypeClass = BuildingSecurityMassageDto.class)
    @RequestMapping(value = "update", method = RequestMethod.POST)
    RequestResult update(@RequestBody BuildingSecurityMassageDto dto);

}
