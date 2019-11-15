package com.aosica.fscp.api.api;

import com.aoscia.base.dto.FightingWaterDto;
import com.aosica.common.bean.RequestResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author liuli
 *
 */
    @Api(tags = "消防水源管理 api")
    @RequestMapping("/fireFightingWaterManage")
    public interface FireFightingWaterManageApi {

    @ApiOperation(value = "获取消防水源信息列表")
    @ApiResponse(code = 200,message = "请求成功",response = RequestResult.class)
    @PostMapping("selectList")
    //RequestResult<List<FightingWaterDto>> selectList(@RequestBody FightingWaterDto dto) ;
    RequestResult<List<FightingWaterDto>> selectList( FightingWaterDto dto) ;


    @ApiOperation(value = "获取消防水源详细信息")
    @ApiResponse(code = 200,message = "请求成功",response = RequestResult.class)
    @PostMapping("selectDetailById")
    RequestResult selectDetailById(String id);

    @ApiOperation(value = "新增或修改消防水源")
    @ApiResponse(code = 200,message = "请求成功",response = RequestResult.class)
    @PostMapping("saveAndUpdate")
    RequestResult saveAndUpdate(@RequestBody FightingWaterDto dto);

    @ApiOperation(value = "删除消防水源")
    @ApiResponse(code = 200,message = "请求成功",response = RequestResult.class)
    @PostMapping("remove")
    RequestResult remove(String id);

}
