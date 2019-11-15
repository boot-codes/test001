package com.aosica.lot.api;


import com.aosica.common.vo.BaseVo;
import com.aosica.lot.dto.AgricultureDeviceDto;
import com.aosica.lot.dto.AgricultureDeviceErrorDto;
import com.aosica.lot.dto.AgricultureDeviceMetricalInfoDto;
import com.aosica.lot.entity.WeatherDevice;
import com.aosica.lot.service.AgricultureDeviceService;
import com.aosica.lot.vo.AgricultureDeviceHistoryDataVo;
import com.aosica.lot.vo.AgricultureDeviceVo;
import com.aosica.lot.vo.OperationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AgricultureDeviceServiceApi implements AgricultureDeviceApi {

    @Autowired
    private AgricultureDeviceService deviceService ;


    /**
     * @param map
     * @return EquipmentDto
     * @description 查询设备详细信息
     */
    @Override
    public AgricultureDeviceDto selectById(Map<String, Object> map) {
        return this.deviceService.selectById(map);
    }

    /**
     * @param map
     * @return List<EquipmentDto>
     * @description 设备列表
     */
    @Override
    public AgricultureDeviceVo listAgricultureDevice(Map<String, Object> map) {
        return this.deviceService.listAgricultureDevice(map);
    }

    /**
     * @return Map<String, Integer>
     * @description 按设备状态统计设备数量
     */
    @Override
    public Map<String, Object> selectCountGroupByStatus() {
        return this.deviceService.selectCountGroupByStatus() ;
    }

    /**
     * @param equipmentDto
     * @description 新增设备
     */
    @Override
    public void saveAndUpdate(AgricultureDeviceDto equipmentDto) {

        this.deviceService.saveAndUpdate(equipmentDto);
    }

    /**
     * @param list
     * @description 批量新增测量信息
     */
    @Override
    public void batchSaveMetricalInfo(List<AgricultureDeviceMetricalInfoDto> list) {

        this.deviceService.batchSaveMetricalInfo(list);
    }

    /**
     * @param list
     * @description 批量修改测量信息
     */
    @Override
    public void batchUpdateMetricaInfo(List<AgricultureDeviceMetricalInfoDto> list) {

        this.deviceService.batchUpdateMetricaInfo(list);
    }

    @Override
    public void remove(List<Long> map) {
        this.deviceService.remove(map);
    }

    /**
     * @return List<BaseVo>
     * @description 获取设备安装位置(下拉接口)
     */
    @Override
    public List<BaseVo> listSite() {
        return this.deviceService.listSite() ;
    }

    /**
     * @param map
     * @return List<EquipmentHistoryDataDto>
     * @description 获取不同类型的历史数据
     */
    @Override
    public AgricultureDeviceHistoryDataVo listHistoryDate(Map<String, Object> map) {
        return this.deviceService.listHistoryDate(map);
    }

    /**
     * @param equipmentId
     * @return List<Map < String, String [ ]>>
     * @description 获取当前设备预警值
     */
    @Override
    public List<Map<String, Object>> getMetricalWarning(long equipmentId) {
        return this.deviceService.getMetricalWarning(equipmentId);
    }

    /**
     * @param map
     * @return OperationVo
     * @description 操作记录列表
     */
    @Override
    public OperationVo listOperation(Map<String, Object> map) {
        return this.deviceService.listOperation(map);
    }

    /**
     * @param map
     * @return List<Map < String, String [ ]>>
     * @description 地图数据接口
     */
    @Override
    public List<Map<String, Object>> listAgricultureDeviceMap(Map<String, Object> map) {
        return this.deviceService.listAgricultureDeviceMap(map);
    }

    /**
     * @return List<Object>
     * @description 设备状态饼图
     */
    @Override
    public List<Object> getAgricultureDevicePie() {
        return this.deviceService.getAgricultureDevicePie() ;
    }

    /**
     * @param map
     * @return List<Map < String, Object>>
     * @description 获取数据监测页面数据
     */
    @Override
    public Map<String, Object> getDataMointor(Map<String, Object> map) {
        return this.deviceService.getDataMointor(map);
    }

    /**
     * @param map
     * @return List<Map < String, Object>>
     * @description 获取实时数据
     */
    @Override
    public List<Map<String, Object>> getRealData(Map<String, Object> map) {
        return this.deviceService.getRealData(map);
    }

    /**
     * @param map
     * @return List<Map < String, Object>>
     * @description 获取异常数据
     */
    @Override
    public List<AgricultureDeviceErrorDto> getWarnData(Map<String, Object> map) {
        return this.deviceService.getWarnData(map);
    }

    /**
     * @param errorDto
     * @return List<Map < String, Object>>
     * @description 修改异常数据
     */
    @Override
    public void updateWarn(AgricultureDeviceErrorDto errorDto) {
        this.deviceService.updateWarn(errorDto);
    }

    /**
     * @param map
     * @return List<Map < String, Object>>
     * @description 获取异常数据
     */
    @Override
    public List<Map<String, Object>> getWeatherData(Map<String, Object> map) {
        return this.deviceService.getWeatherData(map);
    }

    /**
     * @return List<Map < String, Object>>
     * @description 获取状态数据饼图
     */
    @Override
    public List<Map<String, Object>> getStatusByGroupPie() {
        return this.deviceService.getStatusByGroupPie();
    }

    /**
     * @return List<Map < String, Object>>
     * @description 获取状态数据饼图
     */
    @Override
    public List<Map<String, Object>> getRealTimeWarnData() {
        return this.deviceService.getRealTimeWarnData() ;
    }

    /**
     * @return List<Object>
     * @description 获取近一周报警项柱状图
     */
    @Override
    public Map<String, Object> getWarnStaBar() {
        return this.deviceService.getWarnStaBar();
    }

    /**
     * @return List<Object>
     * @description 获取近一周报警次数折线图
     */
    @Override
    public Map<String, Object> getWarnCountLineChart() {
        return this.deviceService.getWarnCountLineChart() ;
    }

    /**
     * @return List<Object>
     * @description 数据可视化实时数据折线图
     */
    @Override
    public List<Map<String, Object>> getRealTimeLineChart() {
        return this.deviceService.getRealTimeLineChart() ;
    }

    @Override
    public Map<String, Object> getPieText() {
        return this.deviceService.getPieText() ;
    }

    /**
     * TODO 功能描述: 根据工程id 获取所有气象设备列表
     *
     * @param projectId
     * @param:
     * @return:
     * @auther: yuzp
     * @date: 2019/8/12 14:41
     */
    @Override
    public List<WeatherDevice> getDeviceList(String projectId) {
        return null;
    }
}
