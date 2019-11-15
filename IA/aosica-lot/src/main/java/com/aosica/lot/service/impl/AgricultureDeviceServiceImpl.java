package com.aosica.lot.service.impl;


import com.aosica.common.config.IdWorker;
import com.aosica.common.exception.AosicaException;
import com.aosica.common.util.CalculateProportionUtil;
import com.aosica.common.util.DateUtil;
import com.aosica.common.vo.BaseVo;
import com.aosica.lot.dto.*;
import com.aosica.lot.entity.WeatherDevice;
import com.aosica.lot.mapper.AgricultureDeviceMapper;
import com.aosica.lot.mapper.WeatherDeviceMapper;
import com.aosica.lot.service.AgricultureDeviceService;
import com.aosica.lot.vo.AgricultureDeviceHistoryDataVo;
import com.aosica.lot.vo.AgricultureDeviceVo;
import com.aosica.lot.vo.OperationVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * @program: ai-planting->EquipmentService
 * @description: 智慧农业设备接口实现类
 * @author: Windows10
 * @create: 2019-08-22 17:11
 **/
@Service
public class AgricultureDeviceServiceImpl implements AgricultureDeviceService {

    @Autowired
    private AgricultureDeviceMapper equipmentMapper;

    @Autowired
    private WeatherDeviceMapper weatherDeviceDataMapper ;

//    @Autowired
//    private FileService fileService;


    @Override
    public AgricultureDeviceDto selectById(Map<String,Object> map) {
        AgricultureDeviceDto equipmentDto = equipmentMapper.selectById(map);
        if(equipmentDto == null){
            throw new AosicaException("设备编号{}"+(String)map.get("number")+"不存在");
        }
        if(equipmentDto != null){
            List<AgricultureDeviceMetricalInfoDto> dtoList = equipmentMapper.getMetricalWarning(equipmentDto.getId());
            equipmentDto.setMetricalInfoDtoList(dtoList);
        }
        return equipmentDto;
    }

    @Override
    public AgricultureDeviceVo listAgricultureDevice(Map<String, Object> map) {
        AgricultureDeviceVo vo = new AgricultureDeviceVo();

//        List<AgricultureDeviceVo>   voList = new ArrayList<>() ;
//        List<AgricultureDeviceDto> list = null ;
        try{
             //当前页
            Integer page = (Integer)map.get("pageIndex");
            if(page == 0 || page.equals("")){
                //默认第一页
                page = 1;
            }
            //  每天显示条数
            Integer rowNum = (Integer)map.get("page");
            if(rowNum == 0 || rowNum.equals("")){
                //默认每页显示10条
                rowNum = 10;
            }
            map.put("rowNum",rowNum);
            map.put("page",page);
            //总的记录数
            int count = equipmentMapper.listEquipmentCount(map);
            if(count> 0){
                // 每页的第一条记录的索引
                int startIndex = (page - 1) * (rowNum);
                map.put("startIndex",startIndex);
                List<AgricultureDeviceDto> list =  equipmentMapper.listAgricultureDevice(map);
                for(AgricultureDeviceDto equipmentDto : list){
                    long id = equipmentDto.getId();
                    String collectionFrequencyStr ="";
                    String collectionFrequencyUnit = equipmentDto.getCollectionFrequencyUnit();
                    if(collectionFrequencyUnit.equals("month")){
                        collectionFrequencyStr = "每"+equipmentDto.getCollectionFrequency()+"月";
                    }else if(collectionFrequencyUnit.equals("day")){
                        collectionFrequencyStr = "每"+equipmentDto.getCollectionFrequency()+"天";
                    }else if(collectionFrequencyUnit.equals("hour")){
                        collectionFrequencyStr = "每"+equipmentDto.getCollectionFrequency()+"小时";
                    }else if(collectionFrequencyUnit.equals("minute")){
                        collectionFrequencyStr = "每"+equipmentDto.getCollectionFrequency()+"分钟";
                    }
                    equipmentDto.setCollectionFrequencyStr(collectionFrequencyStr);
                    //获取设备最新的采集时间
                    String collectionTime = equipmentMapper.getCollectionTime(id);
                    equipmentDto.setCollectionTime(collectionTime);
                }

                vo.setRecordTotal(count);
                vo.setList(list);
            }
        }catch (Exception e){
            throw new AosicaException("获取设备列表信息"+e.getMessage(),e);
        }
        return vo ;
    }

    @Override
    public Map<String, Object> selectCountGroupByStatus() {
        int total = 0;
        String statisticalTime = "";
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Map<String,Object> typeMap = new HashMap<String, Object>();
            typeMap.put("type",2);
            List<Map<String,Object>> list = equipmentMapper.getCountGruopByStatus(typeMap);
            if(!CollectionUtils.isEmpty(list)){
                for(Map<String,Object> paramMap : list){
                    long count = (long)paramMap.get("count");
                    Integer status = (Integer) paramMap.get("status");
                    statisticalTime = (String)paramMap.get("statisticalTime");
                    total +=count;
                    if(status == 1){
                        map.put("online",count);
                    }else if(status == 2){
                        map.put("malfunction",count);
                    }else if(status == 3){
                        map.put("offLine",count);
                    }else if(status == 4){
                        map.put("warn",count);
                    }
                }
            }
            if(!map.containsKey("online")){
                map.put("online",0);
            }
            if(!map.containsKey("malfunction")){
                map.put("malfunction",0);
            }
            if(!map.containsKey("offLine")){
                map.put("offLine",0);
            }
            if(!map.containsKey("warn")){
                map.put("warn",0);
            }
            map.put("total",total);
            map.put("statisticalTime",statisticalTime);
        }catch (Exception e){
            throw new AosicaException("获取不同状态设备数量异常"+e.getMessage(),e);
        }
        return map;
    }

    @Override
    @Transactional(rollbackFor = AosicaException.class)
    public void saveAndUpdate(AgricultureDeviceDto equipmentDto) {
        long id = equipmentDto.getId();
        if(id != 0){
            equipmentDto.setUpdateTime(new Date());
            MultipartFile[] files = equipmentDto.getFiles();
            if(files != null){
               // fileService.uploadFile(equipmentDto.getId(),equipmentDto.getFiles(),"equipment");
            }
            //批量修改测量信息
            this.batchUpdateMetricaInfo(equipmentDto.getMetricalInfoDtoList());
            equipmentMapper.update(equipmentDto);
        }else {
            equipmentDto.setId(IdWorker.generateId());
            equipmentDto.setCreateTime(new Date());
            MultipartFile[] files = equipmentDto.getFiles();
            if(files != null){
                //fileService.uploadFile(equipmentDto.getId(),equipmentDto.getFiles(),"equipment");
            }
            //批量添加测量信息
            this.batchSaveMetricalInfo(equipmentDto.getMetricalInfoDtoList());
            equipmentMapper.save(equipmentDto);
        }
    }

    @Override
    @Transactional(rollbackFor = AosicaException.class)
    public void batchSaveMetricalInfo(List<AgricultureDeviceMetricalInfoDto> list) {
        equipmentMapper.batchSaveMetricalInfo(list);
    }

    @Override
    @Transactional(rollbackFor = AosicaException.class)
    public void batchUpdateMetricaInfo(List<AgricultureDeviceMetricalInfoDto> list) {
            equipmentMapper.batchUpdateMetricalInfo(list);
    }

    @Override
    @Transactional(rollbackFor = AosicaException.class)
    public void remove(List<Long> list) {
            for(Long id : list){
                AgricultureDeviceDto dto = new AgricultureDeviceDto();
                dto.setId(id);
                dto.setIsOnTheScene(0);
                equipmentMapper.update(dto);
            }
    }

    @Override
    public List<BaseVo> listSite() {
        return equipmentMapper.listSite();
    }

    @Override
    public AgricultureDeviceHistoryDataVo listHistoryDate(Map<String, Object> map) {
        AgricultureDeviceHistoryDataVo vo = new AgricultureDeviceHistoryDataVo();
        try{
            //当前页
            Integer page = (Integer)map.get("page");
            if(page == 0 || page.equals("")){
                //默认第一页
                page = 1;
            }
            //  每天显示条数
            Integer rowNum = (Integer)map.get("rowNum");
            if(rowNum == 0 || rowNum.equals("")){
                //默认每页显示10条
                rowNum = 10;
            }
            //总的记录数
            int count = equipmentMapper.listCountHistoryData(map);
            if(count > 0){
                // 每页的第一条记录的索引
                int startIndex = (page - 1) * (rowNum);
                map.put("startIndex",startIndex);
                List<AgricultureDeviceHistoryDataDto>   list = equipmentMapper.listHistoryData(map);
                vo.setList(list);
            }
            vo.setRecordTotal(count);

        }catch (Exception e){
            throw new AosicaException("获取历史数据异常"+e.getMessage(),e);
        }
        return vo;
    }

    @Override
    public List<Map<String, Object>> getMetricalWarning(long equipmentId) {
        List<Map<String, Object>> list =  new ArrayList<Map<String, Object>>();
        try{
            List<AgricultureDeviceMetricalInfoDto>  dtoList = equipmentMapper.getMetricalWarning(equipmentId);
            for(AgricultureDeviceMetricalInfoDto infoDto : dtoList){
                Map<String, Object> map = new HashMap<String, Object>();
                    String name = infoDto.getName();
                    int  warningType = infoDto.getWarningType();
                    String warningValueMin= String.valueOf(infoDto.getWarningValueMin());
                    String warningValueMax = String.valueOf(infoDto.getWarningValueMax());
                    String[] warningValue = new String[]{warningValueMin,warningValueMax};
                    map.put("name",name);
                    map.put("type",warningType);
                    map.put("warn",warningValue);
                    list.add(map);
            }
        }catch (Exception e){
            throw new AosicaException("获取设备预警值异常"+e.getMessage(),e);
        }
        return list;
    }

    @Override
    public OperationVo listOperation(Map<String,Object> map) {
        OperationVo vo = new OperationVo();
        try{
            //当前页
            Integer page = (Integer)map.get("page");
            if(page == 0 || page.equals("")){
                //默认第一页
                page = 1;
            }
            //  每天显示条数
            Integer rowNum = (Integer)map.get("rowNum");
            if(rowNum == 0 || rowNum.equals("")){
                //默认每页显示10条
                rowNum = 10;
            }
            Integer count = equipmentMapper.listOperationCount();
            if(count > 0){
                // 每页的第一条记录的索引
                int startIndex = (page - 1) * (rowNum);
                map.put("startIndex",startIndex);
                List<LogDto> list  = equipmentMapper.listOperation(map);
                vo.setList(list);
            }
            vo.setRecordTotal(count);
        }catch (Exception e){
            throw new AosicaException("获取操作记录异常"+e.getMessage(),e);
        }
        return vo;
    }

    @Override
    public List<Map<String, Object>> listAgricultureDeviceMap(Map<String,Object> map) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try{
            map.put("startIndex",0);
            map.put("rowNum",Integer.MAX_VALUE);
            int type = (int)map.get("type");
            List<AgricultureDeviceDto> dtos = equipmentMapper.listAgricultureDevice(map);
            if(!CollectionUtils.isEmpty(dtos)){
                for(AgricultureDeviceDto dto : dtos){
                    Map<String,Object> parmaMap = new HashMap<String, Object>();
                    long id = dto.getId();
                    String number = dto.getNumber();
                    String name = dto.getName();
                    String installAddress = dto.getInstallAddress();
                    String updateTime = dto.getUpdateTimeStr();
                    int status = dto.getStatus();
                    String[]coordinate = dto.getInstallCoordinate().split(",");
                    if(type == 1){
                        if(status == 4){
                            AgricultureDeviceErrorDto warnDto = equipmentMapper.selectByAgricultureDeviceId(id);
                            parmaMap.put("wranName",warnDto.getErrorName());
                            parmaMap.put("number",number);
                            parmaMap.put("installAddress",installAddress);
                            parmaMap.put("warnTime",updateTime);
                        }
                    }
                    parmaMap.put("name",name);
                    parmaMap.put("position",coordinate);
                    list.add(parmaMap);
                }
            }
        }catch (Exception e){
            throw new AosicaException("获取所有地图显示设备异常"+e.getMessage(),e);
        }
        return list;
    }

    @Override
    public List<Object> getAgricultureDevicePie() {
        List<Object> list = new ArrayList<Object>();
        try{
            List<Map<String,Object>> onLineList = new ArrayList<Map<String,Object>>();
            List<Map<String,Object>> warnList = new ArrayList<Map<String,Object>>();
            Map<String,Object> typeMap = new HashMap<String, Object>();
            typeMap.put("type",2);
            List<Map<String,Object>> mapList = equipmentMapper.getCountGruopByStatus(typeMap);
            int offline = 0;
            int online = 0;
            int warn = 0;
            int normal = 0;
            if(!CollectionUtils.isEmpty(mapList)){
                for(Map<String,Object> paramMap : mapList){
                    long count = (long)paramMap.get("count");
                    Integer status = (Integer) paramMap.get("status");
                    if(status == 3){
                        offline = (int)count;
                    }else {
                        online +=count;
                    }
                    if(status == 4){
                        warn = (int)count;
                    }else {
                        normal +=count;
                    }
                }
            }
            //报警和正常
            Map<String,Object> warnMap = new HashMap<String, Object>();
            warnMap.put("value",warn);
            warnMap.put("name","预警");
            Map<String,Object> normalMap = new HashMap<String, Object>();
            normalMap.put("value",normal);
            normalMap.put("name","正常");
            String warnPercent = CalculateProportionUtil.proportionInt(warn,warn+normal);
            normalMap.put("warnPercent",warnPercent);
            onLineList.add(warnMap);
            onLineList.add(normalMap);
            Map<String,String> warningMap = new HashMap<String, String>();
            warningMap.put("warning",String.valueOf(warn));
            warningMap.put("normal",String.valueOf(normal));
            warningMap.put("warnPercent",warnPercent);

            //在线与离线
            Map<String,Object> onlineMap = new HashMap<String, Object>();
            onlineMap.put("value",online);
            onlineMap.put("name","在线");
            Map<String,Object> offlineMap = new HashMap<String, Object>();
            offlineMap.put("value",offline);
            offlineMap.put("name","离线");
            String percent = CalculateProportionUtil.proportionInt(online,online+offline);
            offlineMap.put("percent",percent);
            warnList.add(onlineMap);
            warnList.add(offlineMap);
            Map<String,String> offlineStaMap = new HashMap<String, String>();
            offlineStaMap.put("online",String.valueOf(online));
            offlineStaMap.put("ogetEquipmentPieffline",String.valueOf(offline));
            offlineStaMap.put("percent",percent);

            list.add(onLineList);
            list.add(warnList);
            list.add(warningMap);
            list.add(offlineStaMap);

        }catch (Exception e){
            throw new AosicaException("获取设备状态饼图异常"+e.getMessage());
        }
        return list;
    }

    @Override
    public  Map<String,Object> getDataMointor(Map<String,Object> paraMap) {
        String siteId = (String)paraMap.get("siteId");
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            List<Map<String,Object>> list = equipmentMapper.selectErrorData(Long.valueOf(siteId));
            if(!CollectionUtils.isEmpty(list)){
                for(Map<String,Object> dataMap : list){
                    String errorTypeStr = (String)dataMap.get("typeStr");
                    long errorType = (long)dataMap.get("errorType");
                    if(!map.containsKey(errorTypeStr)){
                        Map<String,Object> paramMap = new HashMap<String, Object>();
                        paramMap.put("name",(String)dataMap.get("name"));
                        paramMap.put("number",(String)dataMap.get("number"));
                        paramMap.put("installAddress",(String)dataMap.get("installAddress"));
                        paramMap.put("errorType",(long)dataMap.get("errorType"));
                        paramMap.put("collectionTime",(String)dataMap.get("collectionTime"));
                        if(errorType ==  4){
                            paramMap.put("errorValue",(String)dataMap.get("errorValue"));
                            paramMap.put("errorName",(String)dataMap.get("errorName"));
                        }else {
                            paramMap.put("errorName",(String)dataMap.get("errorReason"));
                        }
                        map.put(errorTypeStr,paramMap);
                    }
                }
            }else {
                Map<String,Object> paramMap = new HashMap<String, Object>();
                map.put("warning",paramMap);
                map.put("offline",paramMap);
                map.put("malfunction",paramMap);
            }
            List<Map<String,Object>> warnList = equipmentMapper.getWarnHandel(paraMap);
            for(Map<String,Object>  warnMap : warnList){
                long count = (long)warnMap.get("count");
                String errorName = (String)warnMap.get("errorTypeStr");
                paraMap.put("errorName",errorName);
               Integer total =   equipmentMapper.getWarnByErrorType(paraMap);
                String percent =  CalculateProportionUtil.proportionInt((int)count,total);
                warnMap.put("percent",percent.substring(0,percent.lastIndexOf("%")));
            }

            Map<String,Object> typeMap = new HashMap<String, Object>();
            typeMap.put("type",1);
            typeMap.put("siteId",siteId);
            List<Map<String,Object>>  statusList = equipmentMapper.getCountGruopByStatus(typeMap);
            typeMap.put("startDate",DateUtil.format(new Date(),DateUtil.YYYY_MM_DD));
            List<Map<String,Object>> realTimeList =  equipmentMapper.getRealTimeData(typeMap);
            map.put("warnHandel",warnList);
            map.put("realTime",realTimeList);
            map.put("status",statusList);
        }catch (Exception e){
            throw new AosicaException("获取数据监测数据异常"+e.getMessage());
        }
        return map;
    }

    @Override
    public List<Map<String, Object>> getRealData(Map<String,Object> map) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try{
            //只获取当天的数据
            map.put("startDate",DateUtil.format(new Date(),DateUtil.YYYY_MM_DD));
            list = equipmentMapper.getRealTimeData(map);
        }catch (Exception e){
            throw new AosicaException("获取实时数据异常"+e.getMessage());
        }
        return list;
    }

    @Override
    public List<AgricultureDeviceErrorDto> getWarnData(Map<String,Object> map) {
        List<AgricultureDeviceErrorDto> list = new ArrayList<AgricultureDeviceErrorDto>();
        try{
          list = equipmentMapper.getWarnList(map);
        }catch (Exception e){
            throw new AosicaException("获取异常数据"+e.getMessage(),e);
        }
        return list;
    }

    @Override
    @Transactional(rollbackFor = AosicaException.class)
    public void updateWarn(AgricultureDeviceErrorDto errorDto) {
        equipmentMapper.updateWarn(errorDto);
    }

    @Override
    public List<Map<String, Object>> getWeatherData(Map<String, Object> map) {
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        try{
            int cityId = (Integer) map.get("cityId");
            list = equipmentMapper.getWeatherWarn(cityId);
        }catch (Exception e){
            throw new AosicaException("获取异常数据"+e.getMessage(),e);
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> getStatusByGroupPie() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try{
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("type",2);
            List<Map<String, Object>> dataList = equipmentMapper.getCountGruopByStatus(map);
            for(Map<String,Object> dataMap : dataList){
                Map<String, Object> returnMap = new HashMap<String, Object>();
                String statusStr = (String)dataMap.get("statusStr");
                long count = (long)dataMap.get("count");
                returnMap.put("value",count);
                returnMap.put("name",statusStr);
                list.add(returnMap);
            }
        }catch (Exception e){
            throw new AosicaException("设备状态饼图分布异常"+e.getMessage());
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> getRealTimeWarnData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try{
            String startDate = DateUtil.format(new Date(),DateUtil.YYYY_MM_DD);
            list = equipmentMapper.getRealTimeWarnDate(startDate);
        }catch (Exception e){
            throw new AosicaException("获取实时报警数据异常"+e.getMessage(),e);
        }
        return list;
    }

    @Override
    public Map<String,Object> getWarnStaBar() {
        Map<String,Object> returnMap  = new HashMap<String, Object>();
        List<String> xData = new ArrayList<String>();
        List<String> yData = new ArrayList<String>();
        String str = DateUtil.getPastDate(7,new Date());
        List<String> weekList = DateUtil.getDayList(str,DateUtil.format(new Date(),DateUtil.YYYY_MM_DD));
        try{
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("startDate",weekList.get(0));
            map.put("endDate",weekList.get(6));
            List<Map<String,Object>> list = equipmentMapper.getWarnStaBar(map);
            if(!CollectionUtils.isEmpty(list)){
                for(Map<String,Object> dataMap : list){
                    long count = (long)dataMap.get("count");
                    String errorName = (String)dataMap.get("errorName");
                    yData.add(String.valueOf(count));
                    xData.add(errorName);
                    returnMap.put("xAxis",xData);
                    returnMap.put("yAxis",yData);
                }
            }else {
                returnMap.put("xAxis",xData);
                returnMap.put("yAxis",yData);
            }

        }catch (Exception e){
            throw new AosicaException("获取近一周报警项柱状图统计异常"+e.getMessage(),e);
        }
        return returnMap;
    }

    @Override
    public Map<String, Object> getWarnCountLineChart() {
        Map<String,Object> returnMap  = new HashMap<String, Object>();
        List<String> xData = new ArrayList<String>();
        List<String> yData = new ArrayList<String>();
        String str = DateUtil.getPastDate(7,new Date());
        List<String> weekList = DateUtil.getDayList(str,DateUtil.format(new Date(),DateUtil.YYYY_MM_DD));
        try{
            Map<String,Object> map = new HashMap<String, Object>();
            //本周第一天
            String startDate = weekList.get(0);
            //本周最后一天
            String endDate =weekList.get(6);
            map.put("startDate",startDate);
            map.put("endDate",endDate);
            List<Map<String,Object>> list = equipmentMapper.getWarnCountLineChart(map);
            Map<String,Object> weekValueMap = this.getWeekValueMap(weekList);
            if(!CollectionUtils.isEmpty(list)){
                for(Map<String,Object> dataMap : list){
                    long count = (long)dataMap.get("count");
                    String collectionTime = DateUtil.format((Date)dataMap.get("collectionTime"),DateUtil.YYYY_MM_DD);
                    if(weekValueMap.containsKey(collectionTime)){
                        weekValueMap.put(collectionTime,String.valueOf(count));
                    }
                }
            }
            for(String s : weekList){
                xData.add(s);
                yData.add((String) weekValueMap.get(s));
            }
            returnMap.put("xAxis",xData);
            returnMap.put("yAxis",yData);
        }catch (Exception e){
            throw new AosicaException("获取一周报警次数折线图异常"+e.getMessage(),e);
        }
        return returnMap;
    }

    @Override
    public List<Map<String, Object>> getRealTimeLineChart() {
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
        String str = DateUtil.getPastDate(7,new Date());
        List<String> weekList = DateUtil.getDayList(str,DateUtil.format(new Date(),DateUtil.YYYY_MM_DD));
        try{
            List<Map<String,Object>> typeList = equipmentMapper.getAllMonitorName();
            for(Map<String,Object> sMap: typeList){
                List<String> xData = new ArrayList<String>();
                List<String> yData = new ArrayList<String>();
                Map<String, Object> strMap = new HashMap<String, Object>();
                List<Object> dList = new ArrayList<Object>();
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("startDate",weekList.get(0));
                map.put("endDate",weekList.get(6));
                map.put("valueType",(Integer)sMap.get("warningType"));
                List<Map<String,Object>> dataList = equipmentMapper.getRealTimeAvg(map);
                Map<String, Object> weekValueMap = this.getWeekValueMap(weekList);
                if(!CollectionUtils.isEmpty(dataList)){
                    for(Map<String,Object> dataMap : dataList){
                        double value = (double)dataMap.get("avgValue");
                        String collectionTime = (String)dataMap.get("collectionTime");
                        collectionTime = collectionTime.substring(0,10);
                        if(weekValueMap.containsKey(collectionTime)){
                            weekValueMap.put(collectionTime,String.valueOf(value));
                        }
                    }
                }
                for(String s : weekList){
                    xData.add(s.substring(5));
                    yData.add((String) weekValueMap.get(s));
                }
                dList.add(xData);
                dList.add(yData);
                strMap.put("name",(String) sMap.get("name"));
                strMap.put("data",dList);
                list.add(strMap);
            }
        }catch (Exception e){
            throw new AosicaException("获取实时数据折线图异常"+e.getMessage(),e);
        }
        return list;
    }

    @Override
    public Map<String, Object> getPieText() {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        try{
            Map<String,Object> typeMap = new HashMap<String, Object>();
            typeMap.put("type",2);
            List<Map<String,Object>> mapList = equipmentMapper.getCountGruopByStatus(typeMap);
            int offline = 0;
            int online = 0;
            int warn = 0;
            int normal = 0;
            if(!CollectionUtils.isEmpty(mapList)){
                for(Map<String,Object> paramMap : mapList){
                    long count = (long)paramMap.get("count");
                    Integer status = (Integer) paramMap.get("status");
                    if(status == 3){
                        offline = (int)count;
                    }else {
                        online +=count;
                    }
                    if(status == 4){
                        warn = (int)count;
                    }else {
                        normal +=count;
                    }
                }
            }
            //报警和正常
            String warnPercent = CalculateProportionUtil.proportionInt(warn,warn+normal);
            dataMap.put("warning",String.valueOf(warn));
            dataMap.put("normal",String.valueOf(normal));
            dataMap.put("warnPercent",warnPercent);

            //在线与离线
            String percent = CalculateProportionUtil.proportionInt(online,online+offline);
            dataMap.put("online",String.valueOf(online));
            dataMap.put("offline",String.valueOf(offline));
            dataMap.put("percent",percent);
        }catch (Exception e){
            throw new AosicaException("获取设备状态饼图异常"+e.getMessage());
        }
        return dataMap;
    }

    /**
     * @description 组装每周默认数据
     * @param weekList
     * @return
     */
    private Map<String, Object> getWeekValueMap(List<String> weekList) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        for (String s : weekList) {
            map.put(s,"0");
        }
        return map;
    }



    /**
     * Todo 功能描述 : 根据工程id 获取所有气象设备列表
     *
     * @param projectId
     * @param:
     * @return:
     * @auther: yuzp
     * @date: 2019/8/12 14:41
     */
    @Override
    public List<WeatherDevice> getDeviceList(String projectId) {
        return this.weatherDeviceDataMapper.getWeatherDeviceDataList(projectId);
    }

}



