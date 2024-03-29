//package com.aosica.agriculture.api;

//import com.aosica.agriculture.dto.EquipmentDto;
//import com.aosica.agriculture.dto.EquipmentErrorDto;
//import com.aosica.agriculture.dto.EquipmentMetricalInfoDto;
//import com.aosica.agriculture.vo.EquipmentHistoryDataVo;
//import com.aosica.agriculture.vo.EquipmentVo;
//import com.aosica.agriculture.vo.OperationVo;
//import com.aosica.common.vo.BaseVo;
//
//import java.util.List;
//import java.util.Map;
//
//
///**
// * 智慧农业设备管理 api
// */
//public interface AgricultureDeviceApi {
//
//    /**
//     * @description 查询设备详细信息
//     * @param map
//     * @return EquipmentDto
//     */
//    EquipmentDto selectById(Map<String,Object> map);
//    /**
//     * @description 设备列表
//     * @param map
//     * @return  List<EquipmentDto>
//     */
//    EquipmentVo listEquipment(Map<String,Object> map);
//
//    /**
//     * @description 按设备状态统计设备数量
//     * @return   Map<String,Integer>
//     */
//    Map<String, Object> selectCountGroupByStatus();
//
//    /**
//     * @description 新增设备
//     * @param equipmentDto
//     */
//    void saveAndUpdate(EquipmentDto equipmentDto);
//
//    /**
//     * @description 批量新增测量信息
//     * @param list
//     */
//    void batchSaveMetricalInfo(List<EquipmentMetricalInfoDto> list);
//
//    /**
//     * @description 批量修改测量信息
//     * @param list
//     */
//    void batchUpdateMetricaInfo(List<EquipmentMetricalInfoDto> list);
//
//    void remove(List<Long> map);
//
//    /**
//     * @description 获取设备安装位置(下拉接口)
//     * @return  List<BaseVo>
//     */
//    List<BaseVo> listSite();
//
//    /**
//     * @description 获取不同类型的历史数据
//     * @param map
//     * @return   List<EquipmentHistoryDataDto>
//     */
//    EquipmentHistoryDataVo listHistoryDate(Map<String,Object> map);
//
//    /**
//     * @description 获取当前设备预警值
//     * @param equipmentId
//     * @return   List<Map<String,String[]>>
//     */
//    List<Map<String,Object>> getMetricalWarning(long equipmentId);
//
//    /**
//     * @description 操作记录列表
//     * @param
//     * @return  OperationVo
//     */
//    OperationVo listOperation(Map<String,Object> map);
//
//    /**
//     * @description 地图数据接口
//     * @param
//     * @return   List<Map<String,String[]>>
//     */
//    List<Map<String,Object>> listEquipmentMap(Map<String,Object> map);
//
//    /**
//     * @description 设备状态饼图
//     * @param
//     * @return   List<Object>
//     */
//    List<Object> getEquipmentPie();
//
//    /**
//     * @description 获取数据监测页面数据
//     * @param map
//     * @return  List<Map<String,Object>>
//     */
//   Map<String,Object> getDataMointor(Map<String,Object> map);
//
//    /**
//     * @description 获取实时数据
//     * @param map
//     * @return  List<Map<String,Object>>
//     */
//   List<Map<String,Object>> getRealData(Map<String,Object> map);
//
//    /**
//     * @description 获取异常数据
//     * @return  List<Map<String,Object>>
//     */
//    List<EquipmentErrorDto> getWarnData(Map<String,Object> map);
//
//    /**
//     * @description 修改异常数据
//     * @return  List<Map<String,Object>>
//     */
//    void updateWarn(EquipmentErrorDto errorDto);
//
//    /**
//     * @description 获取异常数据
//     * @return  List<Map<String,Object>>
//     */
//    List<Map<String,Object>> getWeatherData(Map<String,Object> map);
//    /**
//     * @description 获取状态数据饼图
//     * @return  List<Map<String,Object>>
//     */
//    List<Map<String,Object>> getStatusByGroupPie();
//    /**
//     * @description 获取状态数据饼图
//     * @return  List<Map<String,Object>>
//     */
//    List<Map<String,Object>> getRealTimeWarnData();
//
//    /**
//     * @description 获取近一周报警项柱状图
//     * @return  List<Object>
//     */
//    Map<String,Object> getWarnStaBar();
//
//    /**
//     * @description 获取近一周报警次数折线图
//     * @return  List<Object>
//     */
//    Map<String,Object> getWarnCountLineChart();
//
//    /**
//     * @description 数据可视化实时数据折线图
//     * @return  List<Object>
//     */
//    List<Map<String,Object>> getRealTimeLineChart();
//
//    Map<String,Object> getPieText();
//
//
//    List<WeatherDevice> getDeviceList(String projectId) ;
//}
