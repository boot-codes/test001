//package com.aosica.lot.service.impl;
//
//import com.aosica.common.bean.RequestResult;
//import com.aosica.common.config.IdWorker;
//import com.aosica.common.util.DateUtil;
//import com.aosica.lot.dto.EquipmentDto;
//import com.aosica.lot.dto.EquipmentMetricalInfoDto;
//import com.aosica.lot.mapper.EquipmentManagerMapper;
//import com.aosica.lot.service.DeviceService;
//import com.aosica.lot.vo.AgricultureDeviceVo;
//import org.apache.commons.collections.CollectionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.util.*;
//
//
//
//
///**
// *  设备管理模块
// * @PackgeName com.aosica.lot.service.impl
// * @ClassName DeviceServiceImpl.java
// * @Description: TODO
// * @Author: yuzp
// * @Date: 2019/9/11 15:45
// * @UpdateUser: yuzp
// * @UpdateDate: 2019/9/11$ 15:45$
// * @UpdateRemark: TODO
// * @Version: 1.0
// */
//@Service
//public class DeviceServiceImpl implements DeviceService {
//
//
//    @Autowired
//    private EquipmentManagerMapper equipmentManagerMapper;
//
//    /**
//     * 添加单个设备
//     *
//     * @param equipmentDto
//     * @return
//     */
//    @Override
//    public void insertDevice(EquipmentDto equipmentDto)  {
//
//        long id = equipmentDto.getId();
//        if(id != 0){
//            equipmentDto.setUpdateTime(new Date());
//            MultipartFile[] files = equipmentDto.getFiles();
//            if(files != null){
//                //基础服务提供接口
//                //fileService.uploadFile(equipmentDto.getId(),equipmentDto.getFiles(),"equipment");
//            }
//            //批量修改测量信息
//            this.batchInsertDevice(equipmentDto.getMetricalInfoDtoList(),id);
//            equipmentManagerMapper.update(equipmentDto);
//        }else {
//            id = IdWorker.generateId();
//            equipmentDto.setId(id);
//            equipmentDto.setCreateTime(new Date());
//            MultipartFile[] files = equipmentDto.getFiles();
//            if(files != null){
//                //基础服务提供接口 fileService.uploadFile(equipmentDto.getId(),equipmentDto.getFiles(),"equipment");
//            }
//            //批量添加测量信息
//            this.batchInsertDevice(equipmentDto.getMetricalInfoDtoList(),id);
//            equipmentManagerMapper.insert(equipmentDto);
//        }
//    }
//
//    /**
//     * 批量添加添加设备
//     *
//     * @param
//     * @return
//     */
//    @Override
//    public void  batchInsertDevice(List<EquipmentMetricalInfoDto> list, long equipmentId)  {
//        List<EquipmentMetricalInfoDto> saveList = new ArrayList<>();
//        List<EquipmentMetricalInfoDto> updateList = new ArrayList<>();
//        for(EquipmentMetricalInfoDto dto : list){
//            EquipmentMetricalInfoDto infoDto = new EquipmentMetricalInfoDto();
//            long id = dto.getId();
//            if(id == 0){
//                infoDto.setId(IdWorker.generateId());
//                infoDto.setEquipmentId(equipmentId);
//                infoDto.setMeasurementPrecision(dto.getMeasurementPrecision());
//                infoDto.setMeasurementRange(dto.getMeasurementRange());
//                infoDto.setName(dto.getName());
//                infoDto.setNormalValueMax(dto.getNormalValueMax());
//                infoDto.setNormalValueMin(dto.getNormalValueMin());
//                infoDto.setTheory(dto.getTheory());
//                infoDto.setUnit(dto.getUnit());
//                infoDto.setWarningValueMax(dto.getWarningValueMax());
//                infoDto.setWarningValueMin(dto.getWarningValueMin());
//                infoDto.setCreateTime(new Date());
//                saveList.add(infoDto);
//            }else {
//                infoDto.setEquipmentId(equipmentId);
//                infoDto.setMeasurementPrecision(dto.getMeasurementPrecision());
//                infoDto.setMeasurementRange(dto.getMeasurementRange());
//                infoDto.setName(dto.getName());
//                infoDto.setNormalValueMax(dto.getNormalValueMax());
//                infoDto.setNormalValueMin(dto.getNormalValueMin());
//                infoDto.setTheory(dto.getTheory());
//                infoDto.setUnit(dto.getUnit());
//                infoDto.setWarningValueMax(dto.getWarningValueMax());
//                infoDto.setWarningValueMin(dto.getWarningValueMin());
//                infoDto.setUpdateTime(new Date());
//                updateList.add(infoDto);
//            }
//        }
//        //不为空执行批量修改
//        if(!CollectionUtils.isEmpty(updateList)){
//            //equipmentManagerMapper.batchUpdate(updateList);
//        }
//        //不为空执行新增
//        if(!CollectionUtils.isEmpty(saveList)){
//            //equipmentManagerMapper.batchSaveMetricalInfo(saveList);
//        }
//    }
//
//    /**
//     * 更新设备
//     *
//     * @param equipmentDto
//     */
//    @Override
//    public RequestResult updateDevice(EquipmentDto equipmentDto) {
//        return null;
//    }
//
//
//
//    /**
//     * @param id
//     * @param number
//     * @return
//     * @description 查询设备详情信息
//     */
//    @Override
//    public EquipmentDto getDevice(long id, String number)  {
//        Map<String,Object> map = new HashMap<>();
//        map.put("id",id);
//        map.put("number",number);
////        EquipmentDto   equipmentDto = equipmentManagerMapper.selectDetail(map);
////        if(equipmentDto == null){
////            throw new AosicaException("设备编号{}"+(String)map.get("number")+"不存在");
////        }
////        if(equipmentDto != null){
////            List<EquipmentMetricalInfoDto> dtoList = equipmentManagerMapper.selectMetricalInfo(equipmentDto.getId());
////            equipmentDto.setMetricalInfoDtoList(dtoList);
////        }
//        //return equipmentDto;
//        return  null ;
//    }
//
//    /**
//     * @param map
//     * @return
//     * @description 获取设备列表
//     */
//    @Override
//    public AgricultureDeviceVo listEquipment(Map<String, Object> map)  {
//
//        AgricultureDeviceVo vo = new AgricultureDeviceVo();
//        try{
//            //当前页
//            Integer page = (Integer)map.get("pageIndex");
//            if(page == 0 || page.equals("")){
//                //默认第一页
//                page = 1;
//            }
//            //  每天显示条数
//            Integer rowNum = (Integer)map.get("page");
//            if(rowNum == 0 || rowNum.equals("")){
//                //默认每页显示10条
//                rowNum = 10;
//            }
//            map.put("rowNum",rowNum);
//            map.put("page",page);
//            //总的记录数
//            int count = equipmentManagerMapper.selectCount(map);
//            if(count> 0){
//                // 每页的第一条记录的索引
//                int startIndex = (page - 1) * (rowNum);
//                map.put("startIndex",startIndex);
//                List<EquipmentDto> list =  equipmentManagerMapper.selectEquipmentList(map);
//                for(EquipmentDto equipmentDto : list){
//                    long id = equipmentDto.getId();
//                    String collectionFrequencyStr ="";
//                    String collectionFrequencyUnit = equipmentDto.getCollectionFrequencyUnit();
//                    if(collectionFrequencyUnit.equals("month")){
//                        collectionFrequencyStr = "每"+equipmentDto.getCollectionFrequency()+"月";
//                    }else if(collectionFrequencyUnit.equals("day")){
//                        collectionFrequencyStr = "每"+equipmentDto.getCollectionFrequency()+"天";
//                    }else if(collectionFrequencyUnit.equals("hour")){
//                        collectionFrequencyStr = "每"+equipmentDto.getCollectionFrequency()+"小时";
//                    }else if(collectionFrequencyUnit.equals("minute")){
//                        collectionFrequencyStr = "每"+equipmentDto.getCollectionFrequency()+"分钟";
//                    }
//                    equipmentDto.setCollectionFrequencyUnit(collectionFrequencyStr);
//                    //获取设备最新的采集时间
//                    String collectionTime = equipmentManagerMapper.selectNewCollectime(id);
//                    equipmentDto.setCollectionTime(collectionTime);
//                }
//                vo.setList(list);
//                vo.setRecordTotal(count);
//            }
//        }catch (Exception e){
//            //throw new AosicaException("获取设备列表信息"+e.getMessage(),e);
//        }
//        return vo;
//
//    }
//
//    /**
//     * @param projectId
//     * @param siteId
//     * @return
//     * @description 获取设备不同状态下的数量
//     */
//    @Override
//    public Map<String, Object> listEquipment(String projectId, long siteId)  {
//
//        int total = 0;
//        String statisticalTime = DateUtil.format(new Date(),DateUtil.YYYY_MM_DD);
//        Map<String, Object> map = new HashMap<String, Object>();
//        try{
//            Map<String,Object> dataMap = new HashMap<>();
//            dataMap.put("projectId",projectId);
//            dataMap.put("siteId",siteId);
//            List<Map<String,Object>> list = equipmentManagerMapper.listCountGruopByStatus(dataMap);
//            if(!CollectionUtils.isEmpty(list)){
//                for(Map<String,Object> paramMap : list){
//                    long count = (long)paramMap.get("count");
//                    Integer status = (Integer) paramMap.get("status");
//                    total +=count;
//                    if(status == 1){
//                        map.put("online",count);
//                    }else if(status == 2){
//                        map.put("malfunction",count);
//                    }else if(status == 3){
//                        map.put("offLine",count);
//                    }else if(status == 4){
//                        map.put("warn",count);
//                    }
//                }
//            }
//            if(!map.containsKey("online")){
//                map.put("online",0);
//            }
//            if(!map.containsKey("malfunction")){
//                map.put("malfunction",0);
//            }
//            if(!map.containsKey("offLine")){
//                map.put("offLine",0);
//            }
//            if(!map.containsKey("warn")){
//                map.put("warn",0);
//            }
//            map.put("total",total);
//            map.put("statisticalTime",statisticalTime);
//        }catch (Exception e){
//            //throw new AosicaException("获取不同状态设备数量异常"+e.getMessage(),e);
//        }
//        return map;
//    }
//}
