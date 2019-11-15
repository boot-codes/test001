package com.aosica.fscp.controller;

import com.aoscia.base.dto.FightingWaterDto;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.common.util.JsonUtil;
import com.aosica.fscp.api.FireFightingWaterManageSevice;
import com.aosica.lot.dto.DeviceStatisticsDto;
import com.aosica.lot.dto.DeviceSystemTypeNumStatisticsDTO;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

/**
 * @program: ai-planting->FireFightingWaterManageApiService
 * @description: 水源信息管理实现
 * @author: ll
 * @create: 2019-10-30 16:26
 **/
@Api(tags = "消防水源管理 api")
@RequestMapping("/fireFightingWaterManage")
@RestController
public class FireFightingWaterManageController {



    @Autowired
    private FireFightingWaterManageSevice fireFightingWaterManageSevice;






    @ApiOperation(value = "获取消防水源信息列表")
    @ApiResponse(code = 200,message = "请求成功",response = RequestResult.class)
    @PostMapping("selectList")
    public RequestResult<List<FightingWaterDto>> selectList(@RequestBody FightingWaterDto dto) {
        System.out.println("查询水源列表");
        System.out.println("在FireFightingWaterManageApiController打印---2---");
        System.out.println(dto);
        RequestResult<List<FightingWaterDto>> result = this.fireFightingWaterManageSevice.selectList(dto);
        System.out.println("result:"+result);
        return result;
    }

    @ApiOperation(value = "获取消防水源信息列表")
    @ApiResponse(code = 200,message = "请求成功",response = RequestResult.class)
    @PostMapping("list")
    public RequestResult<List<FightingWaterDto>> selectList(@RequestBody HashMap<String, Object> map) {
        System.out.println("查询水源列表");
        System.out.println("在FireFightingWaterManageApiController打印---2---");
        System.out.println(map);
        RequestResult<List<FightingWaterDto>> result = this.fireFightingWaterManageSevice.list(map);
        System.out.println("result:"+result);
        return result;
    }

   /* @ApiOperation(value = "获取消防水源详细信息")
    @ApiResponse(code = 200,message = "请求成功",response = RequestResult.class)
    @PostMapping("selectDetailById")
    public RequestResult selectDetailById(@RequestBody String id) {
        System.out.println("查看消防水源详细信息");
        System.out.println(id);
        *//*  id="1";*//*
        System.out.println("在FireFightingWaterManageApiController打印---2---");
        System.out.println(id);
        return this.fightingWaterApi.selectDetailById(id);
    }*/


    @ApiOperation(value = "获取消防水源详细信息")
    @ApiResponse(code = 200,message = "请求成功",response = RequestResult.class)
    @RequestMapping(value = "/selectDetailById/{id}", method = RequestMethod.GET)
    public RequestResult selectDetailById(@PathVariable(value = "id") String id) {
        System.out.println("获取消防水源详细信息");
        System.out.println("在FireFightingWaterManageApiController打印---2---");
        System.out.println(id);
        return this.fireFightingWaterManageSevice.selectDetailById(id);
    }



    @ApiOperation(value = "新增或修改消防水源")
    @ApiResponse(code = 200,message = "请求成功",response = RequestResult.class)
    @RequestMapping(value = "saveAndUpdate", method = RequestMethod.POST)
    public RequestResult saveAndUpdate(@RequestBody  FightingWaterDto dto) {
        System.out.println("新增或修改消防水源");
       /* dto.setId(0l);
        dto.setProjectId("545");
        dto.setPage(2);
        dto.setPageSize(2);*/

        System.out.println("在FireFightingWaterManageApiController打印---2---");
        System.out.println(dto);
        System.out.println("getBelongArea"+dto.getBelongArea());
        RequestResult requestResult = fireFightingWaterManageSevice.saveAndUpdate(dto);
        System.out.println(requestResult);
        return requestResult;
        //return this.fightingWaterApi.saveAndUpdate(dto);
    }

    @ApiOperation(value = "删除消防水源")
    @ApiResponse(code = 200,message = "请求成功",response = RequestResult.class)
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public RequestResult remove(@PathVariable(value = "id") String id) {

        String s = JsonUtil.objectToJson(id);
        System.out.println("删除消防水源");
        System.out.println("删除的id:" + s);
        return this.fireFightingWaterManageSevice.remove(id);
    }


/*    @ApiOperation(value = "删除消防水源")
    @ApiResponse(code = 200,message = "请求成功",response = RequestResult.class)
    @RequestMapping(value = "/remove2", method = RequestMethod.POST)
    //@RequestMapping(value = "selectDetailById", method = RequestMethod.POST)
    public RequestResult remove2(@RequestBody String id) {

       *//* String s = JsonUtil.objectToJson(id);
        JSONArray array = JSON.parseArray(id);
        JSON.parse
        String string = array.getString(0);
        System.out.println("======"+string);
        Object parse = JSON.parse(id);

        System.out.println(parse.toString());*//*


        System.out.println("POST删除消防水源");
        //System.out.println( "POST删除的id:"+s);
        return this.fightingWaterApi.remove(id);
    }*/

}
