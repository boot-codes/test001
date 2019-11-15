//package com.aosica.lot.mapper;
//
//import com.aosica.lot.dto.EquipmentDto;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public interface EquipmentManagerMapper {
//
//    /**
//     * TODO 功能描述 : 添加设备
//     * @param equipmentDto
//     * @return
//     */
//    int insert(EquipmentDto equipmentDto);
//
//
//    /**
//     * TODO 功能描述 : 修改设备
//     * @param equipmentDto
//     * @return
//     */
//    int update(EquipmentDto equipmentDto);
//
//    /**
//     * TODO 功能描述 : 批量添加设备测量信息
//     * @param infos
//     * @return
//     */
////    int batchSaveMetricalInfo(List<EquipmentMetricalInfoDto> infos);
//
////    /**
////     * TODO 功能描述 : 批量修改设备测量信息
////     * @param infos
////     * @return
////     */
////    int batchUpdate(List<EquipmentMetricalInfoDto> infos);
//
//    /**
//     * TODO 功能描述 : 获取不同状态下设备数量
//     * @param map
//     * @return
//     */
//    List<Map<String,Object>> listCountGruopByStatus(Map<String,Object> map);
//
////    /**
////     * TODO 功能描述 : 获取设备详情信息
////     * @param map
////     * @return
////     */
////    EquipmentDto selectDetail(Map<String,Object> map);
//
////    /**
////     * TODO 功能描述 : 获取设备测量信息
////     * @param equipmentId
////     * @return
////     */
////    List<EquipmentMetricalInfoDto> selectMetricalInfo(long equipmentId);
//
//    /**
//     * TODO 功能描述 : 获取设备列表信息
//     * @param map
//     * @return
//     */
//    List<EquipmentDto> selectEquipmentList(Map<String,Object> map);
//
//    /**
//     * TODO 功能描述 : 获取设备列表总数
//     * @param map
//     * @return
//     */
//    int selectCount(Map<String,Object> map);
//
//    /**
//     * TODO 功能描述 : 获取最新的设备采集数据
//     * @param equipmentId
//     * @return
//     */
//    String selectNewCollectime(long equipmentId);
//
//}
