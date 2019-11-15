package com.aosica.lot.api;


import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.lot.dto.*;
import com.github.pagehelper.Page;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


/**
 *  智慧消防设备管理 api
 * @PackgeName com.aosica.lot.api
 * @ClassName FireFightingDeviceApi.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/23 16:56
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/23$ 16:56$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@Api(value = "智慧消防设备功能模块 api ")
@RequestMapping("/fireFightingDevice")
public interface FireFightingDeviceApi  {


    /**
     * 【建筑物视角 / 设备视觉 】 统计设备数量。
     * 按项目工程统计，统计某个工程下，设备系统的数据，设备的总数量，不正常的设备数量
     * @param
     */
    @ApiOperation(value = "按项目工程统计，统计某个工程下：设备系统的数量，设备的总数量，正常的设备数量，不正常的设备数量")
    @ApiImplicitParam(name ="dto" ,value = "查询对象", dataTypeClass = DeviceStatisticsDto.class)
    @ApiResponse(code = 200,message = "请求成功",response = RequestResultPage.class)
    @RequestMapping(value = "/deviceStatueNumStatistics",method = RequestMethod.POST)
    RequestResultPage<Page<DeviceSystemTypeNumStatisticsDTO>> deviceStatueNumByProjectStatistics(@RequestBody DeviceStatisticsDto dto) ;


    /**
     * 【设备视觉】下的子系统，设备数量统计：
     *  火灾自动报警系统，室内水压监控系统，可燃气体云传输系统，电气火灾监控系统，视频监控系统。子系统的设备数量统计
     * @param dto
     * @return
     */
    @ApiOperation(value = "根据工程id,系统类型，查询消防设备列表数据")
    @ApiImplicitParam(name = "dto",dataTypeClass =DeviceSystemTypeDto.class )
    @ApiResponse(code = 200,message = "请求成功",response = DeviceSystemTypeDto.class)
    @RequestMapping(value = "/pageList",method = RequestMethod.POST)
    RequestResultPage<Page<DeviceSystemTypeDto>> getPageList(@RequestBody FireFightingDeviceQueryDto dto)  ;



    @RequestMapping(value = "/list",method = RequestMethod.POST)
    RequestResult<List<DeviceSystemTypeDto>> getList(@RequestBody FireFightingDeviceQueryDto dto)  ;


    /**
     * 根据查询对象，查询数据
     * @param dto
     * @return
     */
//    @RequestMapping(value = "/getListByCondition",method = RequestMethod.POST)
//    Page<DeviceSystemTypeDto> getListByCondition(@RequestBody FireFightingDeviceQueryDto dto) throws AosicaServiceQueryException;




    /******************************************** 物联监控设备统计 *******************************************************/


    /**
     *  1、设备实时运行情况
     * @return
     */
    @ApiOperation(value = "设备实时运行情况")
    @ApiImplicitParam(name = "deviceQueryDto",dataTypeClass = FireFightingDeviceQueryDto.class,value = "工程id是必填项")
    @RequestMapping(value = "/deviceStatueCount" ,method = RequestMethod.POST)
    RequestResult<HashMap<Integer , DeviceStatueDto>> deviceStatueCount(@RequestBody FireFightingDeviceQueryDto deviceQueryDto) ;


    /**
     * 2、异常设备统计(根据选择的月份，或者年份  统计异常的设备数量)
     * @param
     * @return
     */
    @ApiOperation(value = "异常设备统计(根据选择的月份，或者年份  统计异常的设备数量)")
    @ApiImplicitParam(name = "deviceQueryDto",dataTypeClass = FireFightingDeviceQueryDto.class,value = "工程id是必填项")
    @RequestMapping(value = "/deviceStatueCount/abnormal" ,method = RequestMethod.POST)
    RequestResult<List<DeviceStatueDto>>  deviceStatueCountByMonthOrYear(@RequestBody FireFightingDeviceQueryDto deviceQueryDto) ;


    /**
     * 4、设备异常记录历史查询
     * @return
     */
    @ApiOperation(value = "设备异常记录历史查询")
    @ApiImplicitParam(name = "deviceQueryDto",dataTypeClass = FireFightingDeviceQueryDto.class,value = "工程id是必填项")
    @RequestMapping(value = "/deviceAbnormalRecord" ,method = RequestMethod.POST)
    RequestResultPage<Page<FireFightingDeviceAlarmDto>> deviceAbnormalRecord(@RequestBody FireFightingDeviceAlarmQueryDto alarmQueryDto) ;


    /**
     * 根据建筑物id   获取该建筑物里的系统类型。
     * @param projectId
     * @param buildingId
     * @return
     */
    @ApiOperation(value = "根据建筑物id ,获取该建筑物里的系统类型。")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "projectId",dataType = "String",value = "工程id是必填项") ,
            @ApiImplicitParam(name = "buildingId",dataType = "Long",value = "建筑物id是必填项")
    })
    @RequestMapping(value = "/systemType/{projectId}/{buildingId}",method = RequestMethod.GET)
    RequestResult<List<SystemTypeDTO>> getSystemTypeByBuildId(@PathVariable("projectId") String projectId, @PathVariable("buildingId") Long buildingId) ;








}
