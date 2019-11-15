package com.aosica.lot.service;


import com.aosica.common.vo.BaseVo;
import com.aosica.lot.dto.AgricultureDeviceDto;
import com.aosica.lot.dto.AgricultureDeviceErrorDto;
import com.aosica.lot.dto.AgricultureDeviceMetricalInfoDto;
import com.aosica.lot.entity.WeatherDevice;
import com.aosica.lot.vo.AgricultureDeviceHistoryDataVo;
import com.aosica.lot.vo.AgricultureDeviceVo;
import com.aosica.lot.vo.OperationVo;

import java.util.List;
import java.util.Map;


/**
 * 智慧农业设备管理 service
 */
public interface AgricultureDeviceService {

    /**
     * @description 查询设备详细信息
     * @param map
     * @return EquipmentDto
     */
    AgricultureDeviceDto selectById(Map<String,Object> map);
    /**
     * @description 设备列表
     * @param map
     * @return  List<EquipmentDto>
     */
    AgricultureDeviceVo listAgricultureDevice(Map<String,Object> map);

    /**
     * @description 按设备状态统计设备数量
     * @return   Map<String,Integer>
     */
    Map<String, Object> selectCountGroupByStatus();

    /**
     * @description 新增设备
     * @param equipmentDto
     */
    void saveAndUpdate(AgricultureDeviceDto equipmentDto);

    /**
     * @description 批量新增测量信息
     * @param list
     */
    void batchSaveMetricalInfo(List<AgricultureDeviceMetricalInfoDto> list);

    /**
     * @description 批量修改测量信息
     * @param list
     */
    void batchUpdateMetricaInfo(List<AgricultureDeviceMetricalInfoDto> list);

    void remove(List<Long> map);

    /**
     * @description 获取设备安装位置(下拉接口)
     * @return  List<BaseVo>
     */
    List<BaseVo> listSite();

    /**
     * @description 获取不同类型的历史数据
     * @param map
     * @return   List<EquipmentHistoryDataDto>
     */
    AgricultureDeviceHistoryDataVo listHistoryDate(Map<String,Object> map);

    /**
     * @description 获取当前设备预警值
     * @param equipmentId
     * @return   List<Map<String,String[]>>
     */
    List<Map<String,Object>> getMetricalWarning(long equipmentId);

    /**
     * @description 操作记录列表
     * @param
     * @return  OperationVo
     */
    OperationVo listOperation(Map<String,Object> map);

    /**
     * @description 地图数据接口
     * @param
     * @return   List<Map<String,String[]>>
     */
    List<Map<String,Object>> listAgricultureDeviceMap(Map<String,Object> map);

    /**
     * @description 设备状态饼图
     * @param
     * @return   List<Object>
     */
    List<Object> getAgricultureDevicePie();

    /**
     * @description 获取数据监测页面数据
     * @param map
     * @return  List<Map<String,Object>>
     */
   Map<String,Object> getDataMointor(Map<String,Object> map);

    /**
     * @description 获取实时数据
     * @param map
     * @return  List<Map<String,Object>>
     */
   List<Map<String,Object>> getRealData(Map<String,Object> map);

    /**
     * @description 获取异常数据
     * @return  List<Map<String,Object>>
     */
    List<AgricultureDeviceErrorDto> getWarnData(Map<String,Object> map);

    /**
     * @description 修改异常数据
     * @return  List<Map<String,Object>>
     */
    void updateWarn(AgricultureDeviceErrorDto errorDto);

    /**
     * @description 获取异常数据
     * @return  List<Map<String,Object>>
     */
    List<Map<String,Object>> getWeatherData(Map<String,Object> map);
    /**
     * @description 获取状态数据饼图
     * @return  List<Map<String,Object>>
     */
    List<Map<String,Object>> getStatusByGroupPie();
    /**
     * @description 获取状态数据饼图
     * @return  List<Map<String,Object>>
     */
    List<Map<String,Object>> getRealTimeWarnData();

    /**
     * @description 获取近一周报警项柱状图
     * @return  List<Object>
     */
    Map<String,Object> getWarnStaBar();

    /**
     * @description 获取近一周报警次数折线图
     * @return  List<Object>
     */
    Map<String,Object> getWarnCountLineChart();

    /**
     * @description 数据可视化实时数据折线图
     * @return  List<Object>
     */
    List<Map<String,Object>> getRealTimeLineChart();

    Map<String,Object> getPieText();


    List<WeatherDevice> getDeviceList(String projectId) ;
}
