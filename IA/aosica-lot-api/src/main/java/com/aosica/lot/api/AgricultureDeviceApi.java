package com.aosica.lot.api;


import com.aosica.common.vo.BaseVo;
import com.aosica.lot.dto.AgricultureDeviceDto;
import com.aosica.lot.dto.AgricultureDeviceErrorDto;
import com.aosica.lot.dto.AgricultureDeviceMetricalInfoDto;
import com.aosica.lot.entity.WeatherDevice;
import com.aosica.lot.vo.AgricultureDeviceHistoryDataVo;
import com.aosica.lot.vo.AgricultureDeviceVo;
import com.aosica.lot.vo.OperationVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


/**
 * 智慧农业设备管理 api
 */
@RequestMapping("/lot/agricultureDevice/api")
public interface AgricultureDeviceApi {

    /**
     * @description 查询设备详细信息
     * @param map
     * @return EquipmentDto
     */
    @PostMapping("/selectById")
    AgricultureDeviceDto selectById(Map<String, Object> map);

    /**
     * @description 设备列表
     * @param map
     * @return  List<EquipmentDto>
     */
    @RequestMapping("/listAgricultureDevice")
    AgricultureDeviceVo listAgricultureDevice(Map<String, Object> map);

    /**
     * @description 按设备状态统计设备数量
     * @return   Map<String,Integer>
     */
    @PostMapping("/getCountGroupByStatus")
    Map<String, Object> selectCountGroupByStatus();

    /**
     * @description 新增设备
     * @param equipmentDto
     */
    @PostMapping("/saveAndUpdate")
    void saveAndUpdate(AgricultureDeviceDto equipmentDto);

    /**
     * @description 批量新增测量信息
     * @param list
     */
    @PostMapping("/batchSaveMetricalInfo")
    void batchSaveMetricalInfo(List<AgricultureDeviceMetricalInfoDto> list);

    /**
     * @description 批量修改测量信息
     * @param list
     */
    @PostMapping("/batchUpdateMetricaInfo")
    void batchUpdateMetricaInfo(List<AgricultureDeviceMetricalInfoDto> list);


    @PostMapping("/remove")
    void remove(List<Long> map);

    /**
     * @description 获取设备安装位置(下拉接口)
     * @return  List<BaseVo>
     */
    @PostMapping("/getSite")
    List<BaseVo> listSite();

    /**
     * @description 获取不同类型的历史数据
     * @param map
     * @return   List<EquipmentHistoryDataDto>
     */
    @PostMapping("/getListHistoryDate")
    AgricultureDeviceHistoryDataVo listHistoryDate(Map<String, Object> map);

    /**
     * @description 获取当前设备预警值
     * @param equipmentId
     * @return   List<Map<String,String[]>>
     */
    @PostMapping("/getMetricalWarning")
    List<Map<String,Object>> getMetricalWarning(long equipmentId);

    /**
     * @description 操作记录列表
     * @param
     * @return  OperationVo
     */
    @PostMapping("/listOperation")
    OperationVo listOperation(Map<String, Object> map);

    /**
     * @description 地图数据接口
     * @param
     * @return   List<Map<String,String[]>>
     */
    @PostMapping("/listAgricultureDeviceMap")
    List<Map<String,Object>> listAgricultureDeviceMap(Map<String, Object> map);

    /**
     * @description 设备状态饼图
     * @param
     * @return   List<Object>
     */
    @PostMapping("/getAgricultureDevicePie")
    List<Object> getAgricultureDevicePie();

    /**
     * @description 获取数据监测页面数据
     * @param map
     * @return  List<Map<String,Object>>
     */
    @PostMapping("/getDataMointor")
    Map<String,Object> getDataMointor(Map<String, Object> map);

    /**
     * @description 获取实时数据
     * @param map
     * @return  List<Map<String,Object>>
     */
    @PostMapping("/getRealData")
   List<Map<String,Object>> getRealData(Map<String, Object> map);

    /**
     * @description 获取异常数据
     * @return  List<Map<String,Object>>
     */
    @PostMapping("/getWarnData")
    List<AgricultureDeviceErrorDto> getWarnData(Map<String, Object> map);

    /**
     * @description 修改异常数据
     * @return  List<Map<String,Object>>
     */
    @PostMapping("/updateWarn")
    void updateWarn(AgricultureDeviceErrorDto errorDto);

    /**
     * @description 获取异常数据
     * @return  List<Map<String,Object>>
     */
    @PostMapping("/getWeatherData")
    List<Map<String,Object>> getWeatherData(Map<String, Object> map);
    /**
     * @description 获取状态数据饼图
     * @return  List<Map<String,Object>>
     */
    @PostMapping("/getStatusByGroupPie")
    List<Map<String,Object>> getStatusByGroupPie();


    /**
     * @description 获取状态数据饼图
     * @return  List<Map<String,Object>>
     */
    @PostMapping("/getRealTimeWarnData")
    List<Map<String,Object>> getRealTimeWarnData();

    /**
     * @description 获取近一周报警项柱状图
     * @return  List<Object>
     */
    @PostMapping("/getWarnStaBar")
    Map<String,Object> getWarnStaBar();

    /**
     * @description 获取近一周报警次数折线图
     * @return  List<Object>
     */
    @PostMapping("/getWarnCountLineChart")
    Map<String,Object> getWarnCountLineChart();

    /**
     * @description 数据可视化实时数据折线图
     * @return  List<Object>
     */
    @PostMapping("/getRealTimeLineChart")
    List<Map<String,Object>> getRealTimeLineChart();


    @ApiOperation(value ="数据可视化在线与报警饼图下方文字")
    @PostMapping("/getPieText")
    Map<String,Object> getPieText();


    /**
     * TODO 功能描述: 根据工程id 获取所有气象设备列表
     *  气象(七元素:风速,风向,温度,湿度,雨量,光照,大气压压力)
     * @param:
     * @return:
     * @auther: yuzp
     * @date: 2019/8/12 14:41
     */
    @ApiOperation(value = "根据工程id 获取所有气象设备列表",notes = "")
    @ApiImplicitParam(name = "projectId",value = "工程id")
    @PostMapping("/list")
    List<WeatherDevice> getDeviceList(@RequestParam(value = "projectId") String projectId) ;


}
