package com.aosica.agriculture.controller;

import com.alibaba.fastjson.JSONObject;
import com.aosica.agriculture.api.AgricultureDeviceService;
import com.aosica.common.annotation.LogEvict;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.constant.OperationEnum;
import com.aosica.common.exception.AosicaException;
import com.aosica.common.vo.BaseVo;
import com.aosica.lot.dto.AgricultureDeviceDto;
import com.aosica.lot.dto.AgricultureDeviceErrorDto;
import com.aosica.lot.entity.AgricultureDevice;
import com.aosica.lot.entity.WeatherDevice;
import com.aosica.lot.vo.AgricultureDeviceHistoryDataVo;
import com.aosica.lot.vo.AgricultureDeviceVo;
import com.aosica.lot.vo.OperationVo;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: ai-planting->EquipmentController
 * @description:设备管理控制器
 * @author: dwj
 * @create: 2019-08-22 10:45
 **/
@Api(tags = "设备管理")
@RequestMapping("equipment")
@RestController
public class AgricultureDeviceController {
    private static Logger logger = LoggerFactory.getLogger(AgricultureDeviceController.class);

//    @Autowired
//    private AgricultureDeviceApi equipmentApi;

    @Autowired
    private AgricultureDeviceService agricultureDeviceService ;

//    @Autowired
//    WeatherDeviceManagerService weatherDeviceManagerService;



    @ApiOperation(value ="获取设备详情信息，")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name ="id" ,value = "设备id"),
            @ApiImplicitParam(name ="number" ,value = "设备编号"),
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功",response = AgricultureDevice.class),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/selectById")
    @LogEvict(operEvent = "查看设备详情",operType = OperationEnum.VIEW,explain = "获取设备详情信息", billId = "equipmentId")
    public RequestResult selectById(@RequestBody Map<String,Object> map) {
        RequestResult requestResult = null;
        AgricultureDeviceDto equipmentDto = new   AgricultureDeviceDto();
        try{
            equipmentDto = agricultureDeviceService.selectById(map);
            System.out.println("获取到了数据：" + JSONObject.toJSONString(equipmentDto));
            requestResult = RequestResult.buildOkData(equipmentDto);
        }catch (Exception e){
            if( e instanceof AosicaException){
                requestResult = RequestResult.build(400,e.getMessage(),equipmentDto);
            }else {
                requestResult = RequestResult.build(400,"系统异常",equipmentDto);
            }
            logger.error("系统异常"+e.getMessage(),e);
        }
        return  requestResult ;
    }

    @ApiOperation(value ="获取设备列表信息，")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name ="page" ,value = "当前页"),
            @ApiImplicitParam(name ="rowNum" ,value = "每页显示条数"),
            @ApiImplicitParam(name ="name" ,value = "设备名称"),
            @ApiImplicitParam(name ="status" ,value = "设备状态"),
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功",response = AgricultureDevice.class),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @RequestMapping("/listAgricultureDevice")
    @LogEvict(operEvent = "查看设备列表",operType = OperationEnum.VIEW,explain = "获取设备列表信息")
    public RequestResult listAgricultureDevice(@RequestBody  Map<String,Object> map) {
        RequestResult requestResult = null;
        AgricultureDeviceVo vo = new AgricultureDeviceVo();
        try{
            vo = agricultureDeviceService.listAgricultureDevice(map);
            System.out.println("获取到了数据：" + JSONObject.toJSONString(vo));
            requestResult = RequestResult.buildOkData(vo);
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",vo);
            logger.error("系统异常"+e.getMessage(),e);
        }
        return  requestResult ;
    }

    @ApiOperation(value ="新增设备")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功" ),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/save")
    @LogEvict(operEvent = "新增设备",operType = OperationEnum.ADD,explain = "获取设备信息")
    public RequestResult<AgricultureDeviceDto> save(@RequestBody AgricultureDeviceDto equipmentDto) {
        RequestResult requestResult = null;
        try{
            agricultureDeviceService.saveAndUpdate(equipmentDto);
            requestResult = RequestResult.buildOK();
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",null);
            logger.info("系统异常",e.getMessage());
        }
        return  requestResult ;
    }

    @ApiOperation(value ="修改设备")
    @ApiImplicitParam(name ="id" ,value = "修改时传新增为空",dataTypeClass = AgricultureDeviceDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/update")
    @LogEvict(operEvent = "编辑设备信息",operType = OperationEnum.UPDATE,explain = "编辑设备信息",billId = "id")
    public RequestResult<AgricultureDeviceDto> update(@RequestBody AgricultureDeviceDto equipmentDto) {
        RequestResult requestResult = null;
        try{
            agricultureDeviceService.saveAndUpdate(equipmentDto);
            requestResult = RequestResult.buildOK();
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",null);
            logger.info("系统异常",e.getMessage());
        }
        return  requestResult ;
    }

    @ApiOperation(value ="修改设备")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name ="id" ,value = "修改时传新增为空",dataType = "String"),
            @ApiImplicitParam(name ="isDelete" ,value = "是否删除 0 否 1是",dataType = "int"),
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/remove")
    @LogEvict(operEvent = "删除设备信息",operType = OperationEnum.DELETE,explain = "删除设备信息",billId = "id")
    public RequestResult<AgricultureDeviceDto> remove(@RequestBody List<Long> list) {
        RequestResult requestResult = null;
        try{
            agricultureDeviceService.remove(list);
            requestResult = RequestResult.buildOK();
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",null);
            logger.info("系统异常",e.getMessage());
        }
        return  requestResult ;
    }

    @ApiOperation(value ="获取设备不同状态数量")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/getCountGroupByStatus")
    @LogEvict(operEvent = "查看设备不同状态统计信息",operType = OperationEnum.VIEW,explain = "查看设备不同状态统计信息")
    public RequestResult getCountGroupByStatus() {
        RequestResult requestResult = null;
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            map = agricultureDeviceService.selectCountGroupByStatus();
            System.out.println("获取到了数据：" + JSONObject.toJSONString(map));
            requestResult = RequestResult.buildOkData(map);
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",map);
            logger.error("系统异常",e.getMessage());
        }
        return  requestResult ;
    }



    @ApiOperation(value ="获取设备预警值")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/getMetricalWarning")
    @LogEvict(operEvent = "查看设备预警值",operType = OperationEnum.VIEW,explain = "查看设备预警值信息",billId = "equipmentId")
    public RequestResult getMetricalWarning(@RequestBody Map<String,Object> map) {
        RequestResult requestResult = null;
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        try{
            String equipmentId = (String)map.get("equipmentId");
            list = agricultureDeviceService.getMetricalWarning(Long.valueOf(equipmentId));
            System.out.println("获取到了数据：" + JSONObject.toJSONString(list));
            requestResult = RequestResult.buildOkData(list);
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",list);
            logger.error("系统异常",e.getMessage());
        }
        return  requestResult ;
    }

    @ApiOperation(value ="获取设备安装位置")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/getSite")
    @LogEvict(operEvent = "查询安装位置",operType = OperationEnum.VIEW,explain = "获取安装位置")
    public RequestResult getSite() {
        RequestResult requestResult = null;
        List<BaseVo>  list = new ArrayList<BaseVo>();
        try{
            list = agricultureDeviceService.listSite();
            System.out.println("获取到了数据：" + JSONObject.toJSONString(list));
            requestResult = RequestResult.buildOkData(list);
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",list);
            logger.error("系统异常",e.getMessage());
        }
        return  requestResult ;
    }


    @ApiOperation(value ="获取设备监测历史数据")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/getListHistoryDate")
    @LogEvict(operEvent = "查询监测数据",operType = OperationEnum.VIEW ,explain = "获取设备监测历史数据", billId = "equipmentId")
    public RequestResult getListHistoryDate(@RequestBody Map<String,Object> map) {
        System.out.println("请求的报文{}"+JSONObject.toJSONString(map));
        RequestResult requestResult = null;
        AgricultureDeviceHistoryDataVo vo = new AgricultureDeviceHistoryDataVo();
        try{
            vo = agricultureDeviceService.listHistoryDate(map);
            System.out.println("获取到了数据：" + JSONObject.toJSONString(vo));
            requestResult = RequestResult.buildOkData(vo);
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",vo);
            logger.error("系统异常",e.getMessage());
        }
        return  requestResult ;
    }
    @ApiOperation(value ="操作记录信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/listOperation")
    @LogEvict(operEvent = "操作记录信息",operType = OperationEnum.VIEW ,explain = "操作记录信息")
    public RequestResult listOperation(@RequestBody Map<String,Object> map) {
        RequestResult requestResult = null;
        OperationVo vo = new OperationVo();
        try{
            vo = agricultureDeviceService.listOperation(map);
            System.out.println("获取到了数据：" + JSONObject.toJSONString(vo));
            requestResult = RequestResult.buildOkData(vo);
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",vo);
            logger.error("系统异常",e.getMessage());
        }
        return  requestResult ;
    }


    @ApiOperation(value ="数据可视化地图显示")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/listAgricultureDeviceMap")
    public RequestResult listAgricultureDeviceMap(@RequestBody Map<String,Object> map) {
        RequestResult requestResult = null;
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        try{
            list = agricultureDeviceService.listAgricultureDeviceMap(map);
            System.out.println("获取到了数据：" + JSONObject.toJSONString(list));
            requestResult = RequestResult.buildOkData(list);
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",list);
            logger.error("系统异常",e.getMessage());
        }
        return  requestResult ;
    }

    @ApiOperation(value ="数据可视化在线与报警饼图分布")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/getAgricultureDevicePie")
    public RequestResult getAgricultureDevicePie() {
        RequestResult requestResult = null;
        List<Object> list = new ArrayList<Object>();
        try{
            list = agricultureDeviceService.getAgricultureDevicePie();
            System.out.println("获取到了数据：" + JSONObject.toJSONString(list));
            requestResult = RequestResult.buildOkData(list);
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",list);
            logger.error("系统异常",e.getMessage());
        }
        return  requestResult ;
    }

    @ApiOperation(value ="数据可视化在线与报警饼图下方文字")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/getPieText")
    public RequestResult getPieText() {
        RequestResult requestResult = null;
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            map = agricultureDeviceService.getPieText();
            System.out.println("获取到了数据：" + JSONObject.toJSONString(map));
            requestResult = RequestResult.buildOkData(map);
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",map);
            logger.error("系统异常",e.getMessage());
        }
        return  requestResult ;
    }
    @ApiOperation(value ="数据可视化在线与报警饼图分布")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/getDataMointor")
    public RequestResult getDataMointor(@RequestBody Map<String,Object> paramMap) {
        RequestResult requestResult = null;
        Map<String,Object>  map = new HashMap<String, Object>();
        try{
            map = agricultureDeviceService.getDataMointor(paramMap);
            System.out.println("获取到了数据：" + JSONObject.toJSONString(map));
            requestResult = RequestResult.buildOkData(map);
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",map);
            logger.error("系统异常",e.getMessage());
        }
        return  requestResult ;
    }

    @ApiOperation(value ="获取实时数据")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/getRealData")
    public RequestResult getRealData() {
        RequestResult requestResult = null;
//        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
       WeatherDevice list = new WeatherDevice();
        try{
            String projectId = "10000";
            //获取最新的一条
             list =  agricultureDeviceService.getDeviceList(projectId).get(0);
//            list = equipmentApi.getRealData(map);
            System.out.println("获取到了数据：" + JSONObject.toJSONString(list));
            requestResult = RequestResult.buildOkData(list);
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",list);
            logger.error("系统异常",e.getMessage());
        }
        return  requestResult ;
    }

    @ApiOperation(value ="获取报警数据")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/getWarnData")
    public RequestResult getWarnData(@RequestBody Map<String,Object> map) {
        RequestResult requestResult = null;
        List<AgricultureDeviceErrorDto> list = new ArrayList<AgricultureDeviceErrorDto>();
        try{
            list = agricultureDeviceService.getWarnData(map);
            System.out.println("获取到了数据：" + JSONObject.toJSONString(list));
            requestResult = RequestResult.buildOkData(list);
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",list);
            logger.error("系统异常",e.getMessage());
        }
        return  requestResult ;
    }




    @ApiOperation(value ="获取预警报告数据")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/getWeatherData")
    public RequestResult getWeatherData(@RequestBody Map<String,Object> map) {
        RequestResult requestResult = null;
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        try{
            list = agricultureDeviceService.getWeatherData(map);
            System.out.println("获取到了数据：" + JSONObject.toJSONString(list));
            requestResult = RequestResult.buildOkData(list);
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",list);
            logger.error("系统异常",e.getMessage());
        }
        return  requestResult ;
    }


    @ApiOperation(value ="处理遗异常数据")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/updateWarn")
    public RequestResult updateWarn(@RequestBody AgricultureDeviceErrorDto dto) {
        RequestResult requestResult = null;
        try{
            agricultureDeviceService.updateWarn(dto);
            requestResult = RequestResult.buildOK();
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",null);
            logger.error("系统异常",e.getMessage());
        }
        return  requestResult ;
    }

    @ApiOperation(value ="获取设备状态饼图")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/getStatusByGroupPie")
    public RequestResult getStatusByGroupPie() {
        RequestResult requestResult = null;
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        try{
            list = agricultureDeviceService.getStatusByGroupPie();
            requestResult = RequestResult.buildOkData(list);
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",list);
            logger.error("系统异常",e.getMessage());
        }
        return  requestResult ;
    }

    @ApiOperation(value ="获取实时数据报警")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/getRealTimeWarnData")
    public RequestResult getRealTimeWarnData() {
        RequestResult requestResult = null;
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        try{
            list = agricultureDeviceService.getRealTimeWarnData();
            requestResult = RequestResult.buildOkData(list);
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",list);
            logger.error("系统异常",e.getMessage());
        }
        return  requestResult ;
    }

    @ApiOperation(value ="获取近一周报警项柱状图统计")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/getWarnStaBar")
    public RequestResult getWarnStaBar() {
        RequestResult requestResult = null;
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            map = agricultureDeviceService.getWarnStaBar();
            requestResult = RequestResult.buildOkData(map);
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",map);
            logger.error("系统异常",e.getMessage());
        }
        return  requestResult ;
    }


    @ApiOperation(value ="获取近一周报警次数折线图统计")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/getWarnCountLineChart")
    public RequestResult getWarnCountLineChart() {
        RequestResult requestResult = null;
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            map = agricultureDeviceService.getWarnCountLineChart();
            requestResult = RequestResult.buildOkData(map);
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",map);
            logger.error("系统异常",e.getMessage());
        }
        return  requestResult ;
    }

    @ApiOperation(value ="数据可视化实时数据折线图")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400,message = "请求失败")
    })
    @PostMapping("/getRealTimeLineChart")
    public RequestResult getRealTimeLineChart() {
        RequestResult requestResult = null;
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        try{
            list = agricultureDeviceService.getRealTimeLineChart();
            requestResult = RequestResult.buildOkData(list);
        }catch (Exception e){
            requestResult = RequestResult.build(400,"系统异常",list);
            logger.error("系统异常",e.getMessage());
        }
        return  requestResult ;
    }
}
