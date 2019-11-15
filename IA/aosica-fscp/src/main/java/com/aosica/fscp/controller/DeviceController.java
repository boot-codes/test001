package com.aosica.fscp.controller;


import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.common.util.ObjectUtil;
import com.aosica.fscp.api.FireFightingDeviceService;
import com.aosica.lot.dto.*;
import com.github.pagehelper.Page;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

/**
 *
 *  智慧消防设备功能模块 api
 * @PackgeName com.aosica.fscp.controller
 * @ClassName DeviceController.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/10/17 19:49
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/10/17$ 19:49$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@Api(value = "智慧消防设备功能模块 api ",tags = "智慧消防设备功能模块 api")
@Controller
@RequestMapping("/web/device/fire")
public class DeviceController {


    @Autowired
    private FireFightingDeviceService deviceService ;


    /**
     * 【建筑物视角 / 设备视觉 】 统计设备数量。
     * 按项目工程统计，统计某个工程下，设备系统的数据，设备的总数量，不正常的设备数量
     * 按项目工程统计，统计某个工程下：设备系统的数量，设备的总数量，正常的设备数量，不正常的设备数量
     * @param
     */
    @ApiOperation(value = "建筑物视角 设备视觉 总数量统计")
    @ApiImplicitParam(name ="dto" ,value = "查询对象", dataType = "DeviceStatisticsDto")
    @ApiResponse(code = 200,message = "请求成功",reference = "DeviceSystemTypeNumStatisticsDTO")
    @RequestMapping(value = "/deviceStatueNumStatistics",  method = RequestMethod.POST)
    @ResponseBody
    RequestResultPage<Page<DeviceSystemTypeNumStatisticsDTO>> deviceStatueNumByProjectStatistics(@RequestBody @Valid DeviceStatisticsDto dto
                                                                                                , BindingResult bindingResult) {
        System.out.println("志鹏的服务");
        if(bindingResult.hasErrors()) {
            return  RequestResultPage.build(500 , bindingResult.getFieldError().getDefaultMessage()) ;
        }
        return  this.deviceService.deviceStatueNumByProjectStatistics(dto) ;
    }


    /**
     * 【设备视觉】下的子系统，设备数量统计：
     *  火灾自动报警系统，室内水压监控系统，可燃气体云传输系统，电气火灾监控系统，视频监控系统。子系统的设备数量统计
     * @param dto
     * @return
     */
    @ApiOperation(value = "设备视觉下的子系统列表，设备数量统计根据工程id,系统类型，查询消防设备列表数据")
    @ApiImplicitParam(name = "dto",dataType = "FireFightingDeviceQueryDto")
    @ApiResponse(code = 200,message = "请求成功",response = RequestResultPage.class)
    @RequestMapping(value = "/pageList" , method = RequestMethod.POST)
    @ResponseBody
    RequestResultPage<Page<DeviceSystemTypeDto>> getPageList(@RequestBody FireFightingDeviceQueryDto dto
                                                                         , BindingResult bindingResult)  {
        if(bindingResult.hasErrors()) {
            return  RequestResultPage.build(500 , bindingResult.getFieldError().getDefaultMessage()) ;
        }

        ////RequestResultPage<Page<DeviceSystemTypeDto>> requestResultPage = this.deviceService.getList(dto);
       RequestResultPage<Page<DeviceSystemTypeDto>> requestResultPage = this.deviceService.getPageList(dto);
       return requestResultPage ;
      // return  null;
    }


    /**
     * 根据查询对象，查询消防设备数据
     * @param dto
     * @return
     */
//    @ApiOperation(value = "根据查询条件,查询消防设备数据")
//    @ApiImplicitParam(name = "dto",dataType= "FireFightingDeviceQueryDto" )
//    @ApiResponse(code = 200,message = "请求成功",response = RequestResult.class)
//    @RequestMapping(value = "/getListByCondition",method = RequestMethod.POST)
//    @ResponseBody
//    RequestResult<Page<DeviceSystemTypeDto>> getListByCondition(@RequestBody FireFightingDeviceQueryDto dto) {
//
//        String errorMessage = null ;
//        try {
//            errorMessage = ObjectUtil.checkNotEmpty(dto.getProjectId(), "工程id 不能为空") ;
//        }
//        catch (Exception e) {
//            return  RequestResult.build(500 , errorMessage) ;
//        }
//        return  this.deviceService.getListByCondition(dto) ;
//        return  null ;
//    }




    /******************************************** 物联监控设备统计 *******************************************************/


    /**
     *  1、设备实时运行情况
     * @return
     */
    @ApiOperation(value = "设备实时运行情况")
    @ApiImplicitParam(name = "deviceQueryDto",dataType = "FireFightingDeviceQueryDto",value = "工程id是必填项")
    @RequestMapping(value = "/deviceStatueCount", method = RequestMethod.POST)
    @ResponseBody
    RequestResult<HashMap<Integer , DeviceStatueDto>> deviceStatueCount(@RequestBody FireFightingDeviceQueryDto deviceQueryDto) {

        String errorMessage = null ;
        try {
            errorMessage = ObjectUtil.checkNotEmpty(deviceQueryDto.getProjectId(), "工程id 不能为空") ;
        }
        catch (Exception e) {
            return  RequestResult.build(500 , errorMessage) ;
        }
        return  this.deviceService.deviceStatueCount(deviceQueryDto) ;
        //return null;
    }


    /**
     * 2、异常设备统计(根据选择的月份，或者年份  统计异常的设备数量)
     * @param
     * @return
     */
    @ApiOperation(value = "异常设备统计(根据选择的月份，或者年份  统计异常的设备数量)")
    @ApiImplicitParam(name = "deviceQueryDto",dataType = "FireFightingDeviceQueryDto" ,value = "工程id是必填项")
    @RequestMapping(value = "/deviceStatueCount/abnormal" ,method = RequestMethod.POST)
    @ResponseBody
    RequestResult<List<DeviceStatueDto>>  deviceStatueCountByMonthOrYear(@RequestBody FireFightingDeviceQueryDto deviceQueryDto
                                                                                                  , BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return  RequestResult.build(500 , bindingResult.getFieldError().getDefaultMessage()) ;
        }
        return  this.deviceService.deviceStatueCountByMonthOrYear(deviceQueryDto) ;
    }


    /**
     * 4、设备异常记录历史查询
     * @return
     */
    @ApiOperation(value = "设备异常记录历史查询")
    @ApiImplicitParam(name = "deviceQueryDto",dataType = "FireFightingDeviceQueryDto",value = "工程id是必填项")
    @ApiResponse(code = 200,message = "请求成功",reference = "FireFightingDeviceAlarmDto")
    @RequestMapping(value = "/deviceAbnormalRecord" ,method = RequestMethod.POST)
    @ResponseBody
    RequestResultPage<Page<FireFightingDeviceAlarmDto>> deviceAbnormalRecord(@RequestBody FireFightingDeviceAlarmQueryDto alarmQueryDto
                                                                                                     , BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return  RequestResultPage.build(500 , bindingResult.getFieldError().getDefaultMessage()) ;
        }

        return this.deviceService.deviceAbnormalRecord(alarmQueryDto) ;
    }


    @ApiOperation(value = "根据建筑物id ,获取该建筑物里的系统类型。")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "projectId",dataType = "String",value = "工程id是必填项") ,
            @ApiImplicitParam(name = "buildingId",dataType = "Long",value = "建筑物id是必填项")
    })
    @RequestMapping(value = "/systemType/{projectId}/{buildingId}",method = RequestMethod.GET)
    @ResponseBody
    RequestResult<List<SystemTypeDTO>> getSystemTypeByBuildId(@PathVariable("projectId") String projectId , @PathVariable("buildingId") Long buildingId) {
        System.out.println("进入getSystemTypeByBuildId");
        System.out.println(projectId+"\\\\\\"+buildingId);
        String errorMessage = null ;
        try {
            errorMessage = ObjectUtil.checkNotEmpty(projectId, "工程 id 不能为空");
           // errorMessage = ObjectUtil.checkLong(buildingId,"建筑物 id 是必填项") ;
        } catch (Exception e) {
            e.printStackTrace();
            return  RequestResult.build(500,errorMessage) ;
        }
        System.out.println("执行getSystemTypeByBuildId");
        RequestResult<List<SystemTypeDTO>> systemTypeByBuildId = this.deviceService.getSystemTypeByBuildId(projectId, buildingId);
        System.out.println(systemTypeByBuildId);
        return systemTypeByBuildId;
      //  return this.deviceService.getSystemTypeByBuildId(projectId,buildingId) ;
    }






}
