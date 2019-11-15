//package com.aosica.lot.api;
//
//import com.aosica.common.bean.RequestResult;
//import com.aosica.common.exception.AosicaException;
//import com.aosica.common.exception.AosicaServiceQueryException;
//import com.aosica.lot.dto.AgricultureDeviceDto;
//import com.aosica.lot.dto.AgricultureDeviceMetricalInfoDto;
//import com.aosica.lot.service.DeviceService;
//import com.aosica.lot.vo.AgricultureDeviceVo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.Map;
//
//import static com.aosica.common.bean.RequestResult.FAIL_CODE;
//import static com.aosica.common.bean.RequestResult.FAIL_MESSAGE;
//
///**
// *  设备管理
// * @program: ai-planting->EquipmentManagerService
// * @description: 设备实现类
// * @author: dwj
// * @create: 2019-09-11 10:47
// **/
//@RestController
//public class EquipmentManagerServiceApi implements EquipmentManagerApi {
//
//
//    @Autowired
//    private DeviceService deviceService ;
//
//    /**
//     * @description 设备新增或修改
//     * @param equipmentDto
//     */
//    @Override
//    @Transactional(rollbackFor = AosicaException.class)
//    public RequestResult save(AgricultureDeviceDto equipmentDto) {
//
//        try {
//            this.deviceService.insertDevice(equipmentDto);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return RequestResult.build(FAIL_CODE, FAIL_MESSAGE) ;
//        }
//        return RequestResult.buildOK() ;
//    }
//
//    /**
//     * @description 批量新增或修改设备测量信息
//     * @param list
//     * @param equipmentId
//     */
//    @Override
//    public RequestResult batchSaveAndUpdateMetricalInfo(List<AgricultureDeviceMetricalInfoDto> list, long equipmentId) {
//
//        try {
//            this.deviceService.batchInsertDevice(list, equipmentId);
//            return RequestResult.buildOK() ;
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return RequestResult.build(FAIL_CODE, FAIL_MESSAGE) ;
//        }
//
//    }
//
//    /**
//     * @description 获取设备不同状态下的数量
//     * @param projectId
//     * @param siteId
//     * @return
//     */
//    @Override
//    public RequestResult selectCountGroupByStatus(String projectId,long siteId) {
//
//        Map<String, Object> stringObjectMap = null;
//        try {
//            stringObjectMap = this.deviceService.listEquipment(projectId, siteId);
//            return RequestResult.buildOkData(stringObjectMap) ;
//        } catch (AosicaServiceQueryException e) {
//            e.printStackTrace();
//            return RequestResult.build(FAIL_CODE, FAIL_MESSAGE) ;
//        }
//    }
//
//    /**
//     * @description 设备详情信息
//     * @param id
//     * @param number
//     * @return
//     */
//    @Override
//    public RequestResult listEquipmentDetail(long id, String number) {
//        AgricultureDeviceDto device = null;
//        try {
//            device = this.deviceService.getDevice(id, number);
//            return RequestResult.buildOkData(device) ;
//        }
//        catch (AosicaServiceQueryException e) {
//            e.printStackTrace();
//            return RequestResult.build(FAIL_CODE, FAIL_MESSAGE) ;
//        }
//    }
//
//    /**
//     * @description 获取设备列表
//     * @param map
//     * @return
//     */
//    @Override
//    public RequestResult listEquipment(Map<String, Object> map) {
//
//        AgricultureDeviceVo equipmentVo = null;
//        try {
//            equipmentVo = this.deviceService.listEquipment(map);
//            return RequestResult.buildOkData(equipmentVo) ;
//        }
//        catch (AosicaServiceQueryException e) {
//            e.printStackTrace();
//            return RequestResult.build(FAIL_CODE, FAIL_MESSAGE) ;
//        }
//    }
//
//
//}
