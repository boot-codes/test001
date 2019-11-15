//package com.aosica.lot.api;
//
//import com.aosica.common.bean.RequestResult;
//import com.aosica.lot.dto.AgricultureDeviceDto;
//import com.aosica.lot.dto.AgricultureDeviceMetricalInfoDto;
//import com.aosica.lot.entity.AgricultureDevice;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @program: ai-planting->EquipmentManagerApi
// * @description: 设备接口
// * @author: dwj
// * @create: 2019-09-11 10:42
// **/
//@Api(tags = "设备管理 api")
//@RequestMapping("/lot/equipment")
//public interface  EquipmentManagerApi {
//
//    @ApiOperation(value = "新增设备",notes = "")
//    @ApiImplicitParam(dataTypeClass = AgricultureDevice.class)
//    @PostMapping("/save")
//    RequestResult save(AgricultureDeviceDto equipmentDto);
//
//
//    @ApiOperation(value = "批量新增和修改设备测量信息",notes = "")
//    @ApiImplicitParam(dataTypeClass = AgricultureDeviceMetricalInfoDto.class)
//    RequestResult batchSaveAndUpdateMetricalInfo(List<AgricultureDeviceMetricalInfoDto> list, long equipmentId);
//
//    @ApiOperation(value = "获取设备不同状态下的数量",notes = "")
//    @ApiImplicitParams(value = {
//            @ApiImplicitParam(name = "projectId",value = "工程id"),
//            @ApiImplicitParam(name ="siteId" ,value = "安装位置Id"),
//    })
//    @PostMapping("/getCountGroupByStatus")
//    RequestResult selectCountGroupByStatus(@RequestParam(value = "projectId") String projectId,@RequestParam(value = "siteId",required = false) long siteId);
//
//    /**
//     * @description 查询设备详细信息
//     * @param id
//     * @return EquipmentDto
//     */
//    @ApiOperation(value = "获取设备详情信息",notes = "")
//    @ApiImplicitParams(value = {
//            @ApiImplicitParam(name = "id",value = "设备Id"),
//            @ApiImplicitParam(name ="number" ,value = "设备编号"),
//    })
//    @PostMapping("/listEquipmentDetail")
//    RequestResult listEquipmentDetail(@RequestParam(value = "id") long id,@RequestParam(value = "number",required = false) String number);
//
//    /**
//     * @description 查询设备列表信息
//     * @param map
//     * @return EquipmentDto
//     */
//    @ApiOperation(value = "获取设备列表",notes = "")
//    @ApiImplicitParam(dataTypeClass = Map.class)
//    @PostMapping("/listEquipment")
//    RequestResult listEquipment(Map<String,Object> map);
//
//}
