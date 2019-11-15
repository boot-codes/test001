package com.aosica.agriculture.controller;


import com.aosica.agriculture.api.EquipmentExcelService;
import com.aosica.common.bean.RequestResult;
import com.aosica.lot.entity.AgricultureDevice;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: ai-planting->EquipmentController
 * @description:设备管理控制器
 * @author: dwj
 * @create: 2019-08-22 10:45
 **/
@Api(tags = "设备管理")
@RequestMapping("excel")
@Controller
public class EquipmentExcelController {
    private static Logger logger = LoggerFactory.getLogger(EquipmentExcelController.class);

//    @Autowired
//    private EquipmentExcelRepository demoExcelRepository;


//    @Autowired
//    private AgricultureDeviceMapper equipmentMapper;

    @Autowired
    private EquipmentExcelService equipmentExcelService;


    @ApiOperation(value = "批量导出设备列表，")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "startIndex", value = "当前页"),
            @ApiImplicitParam(name = "rowNum", value = "每页显示条数"),
            @ApiImplicitParam(name = "status", value = "设备状态"),
            @ApiImplicitParam(name = "name", value = "设备名称"),
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = AgricultureDevice.class),
            @ApiResponse(code = 400, message = "请求失败")
    })
    @GetMapping(value = "/export")
    //@LogEvict(operEvent = "批量导出设备列表", operType = OperationEnum.VIEW, explain = "批量导出设备列表")
    public void export(HttpServletRequest request, HttpServletResponse response,
                       Integer startIndex,
                       Integer rowNum,
                       String status,
                       String name) {
        RequestResult requestResult = null;
        try {
            equipmentExcelService.export(request, response,
                    startIndex,
                    rowNum,
                    status,
                    name);
        } catch (Exception e) {
            e.printStackTrace();
            requestResult = RequestResult.build(400, "系统异常");
            logger.error("系统异常" + e.getMessage(), e);
        }
    }


    @PostMapping("/importExcel")
    public void importExcel(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        RequestResult requestResult = null;
        try {
            equipmentExcelService.importExcel(file, request, response);
        } catch (Exception e) {
            requestResult = RequestResult.build(400, "系统异常");
            logger.error("系统异常" + e.getMessage(), e);
            e.printStackTrace();
        }
    }

    @GetMapping("/downloadExcel")
    public void downloadExcel(HttpServletRequest request, HttpServletResponse response) {
        RequestResult requestResult = null;
        try {
            equipmentExcelService.downloadExcel(response);
        } catch (Exception e) {
            requestResult = RequestResult.build(400, "系统异常");
            logger.error("系统异常" + e.getMessage(), e);
            e.printStackTrace();
        }
    }

}
