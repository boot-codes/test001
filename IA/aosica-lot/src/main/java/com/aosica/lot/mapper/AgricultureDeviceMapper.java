package com.aosica.lot.mapper;

import com.aosica.common.vo.BaseVo;
import com.aosica.lot.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @program:
 * @description: 设备接口
 * @author: dwj
 * @create: 2019-08-21 19:05
 **/
@Mapper
public interface AgricultureDeviceMapper {

    AgricultureDeviceDto selectById(Map<String, Object> map);

    List<AgricultureDeviceDto> listAgricultureDevice(Map<String, Object> map);

    Integer listEquipmentCount(Map<String, Object> map);

    void save(AgricultureDeviceDto equipmentDto);

    void update(AgricultureDeviceDto equipmentDto);

    List<BaseVo> listSite();

    void batchSaveMetricalInfo(List<AgricultureDeviceMetricalInfoDto> list);

    void batchUpdateMetricalInfo(List<AgricultureDeviceMetricalInfoDto> list);

    List<AgricultureDeviceHistoryDataDto> listHistoryData(Map<String, Object> map);

    Integer listCountHistoryData(Map<String, Object> map);

    List<AgricultureDeviceMetricalInfoDto> getMetricalWarning(long equipmentId);

    String getCollectionTime(long equipmentId);

    List<Map<String,Object>> getCountGruopByStatus(Map<String, Object> map);

    List<LogDto>  listOperation(Map<String, Object> map);

    Integer  listOperationCount();

    AgricultureDeviceErrorDto selectByAgricultureDeviceId(long equipmentId);

    List<Map<String,Object>> selectErrorData(long siteId);

    List<Map<String,Object>> getWarnHandel(Map<String, Object> map);

    List<Map<String,Object>> getRealTimeData(Map<String, Object> map);

    List<AgricultureDeviceErrorDto> getWarnList(Map<String, Object> map);

    void updateWarn(AgricultureDeviceErrorDto errorDto);

    List<Map<String,Object>> getWeatherWarn(int cityId);

    List<Map<String,Object>> getRealTimeWarnDate(String startDate);

    List<Map<String,Object>> getWarnStaBar(Map<String, Object> map);

    List<Map<String,Object>> getWarnCountLineChart(Map<String, Object> map);

    int getWarnByErrorType(Map<String, Object> map);

    List<Map<String,Object>> getRealTimeAvg(Map<String, Object> map);

    List<Map<String,Object>> getAllMonitorName();
}
