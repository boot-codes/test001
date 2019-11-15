package com.aosica.fscp.controller;


import com.aosica.common.bean.RequestResult;
import com.aosica.fscp.api.FireFightingDeviceService;
import com.aosica.fscp.export.excel.dto.ExcelExportDTO;
import com.aosica.fscp.export.excel.service.ExcelService;
import com.aosica.lot.dto.DeviceSystemTypeDto;
import com.aosica.lot.dto.FireFightingDeviceQueryDto;
import io.swagger.annotations.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;


/**
 *  excel 导出，上传服务类
 * @PackgeName com.aosica.fscp.controller
 * @ClassName FscpExcelServiceController.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/10/14 16:29
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/10/14$ 16:29$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@Api(value = "excel 导出/上传 服务 ",tags = "excel 导出/上传 服务")
@Controller
@RequestMapping("/fscp/excel")
//@CrossOrigin(origins = "*",maxAge = 3600)
public class ExcelServiceController {


    private final static Logger LOGGER = LoggerFactory.getLogger(ExcelServiceController.class) ;

    private static final String[][] sheetTitleArray = {{"系统类型","4500"},{"设备类型","2500"},{"设备id","4500"},{"建筑物名称","4500"}
    ,{"监管单位","5500"},{"安装位置","4500"},{"设备状态","4500"},{"设备处理时间","4500"}} ;


    @Autowired
    private FireFightingDeviceService deviceService ;


    @Autowired
    private ExcelService excelService ;


    /**
     * excel 下载
     */
    @ApiOperation(value = "火灾、室内水压、可燃气体、电气火灾，视频等设备数据 excel 下载")
    @ApiImplicitParam(name = "deviceQueryDto",value = "封装的查询各种系统类型设备的查询DTO对象",dataType = "FireFightingDeviceQueryDto"
            , examples = @Example(value = @ExampleProperty(mediaType = "fbk", value = "如果只导出指定id的数据，设置fbk= 335356683625152512,335946275818553344,335947445127593984")))
    @RequestMapping(value = "/export",method = RequestMethod.GET)
    public void excelExport(@RequestBody FireFightingDeviceQueryDto deviceQueryDto, @Validated Errors error , HttpServletResponse response ) throws Exception {

//        response.setHeader("Access-Control-Allow-Origin","*");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, PUT");
//        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//
//        LOGGER.info("deviceQueryDto : " +deviceQueryDto);
//        if(error.hasErrors() || StringUtils.isBlank(deviceQueryDto.getSystemType())) {
//            LOGGER.error("缺少必填的字段.............");
//            return  ;
//        }

//        String systemType= "火灾自动报警系统" ;

        String systemType = deviceQueryDto.getSystemType();
//
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/force-download");
        response.setContentType("application/octet-stream");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(systemType+".xlsx", "UTF-8"));


        //需要下载文件的字节数组
        //byte[] modelByte = Base64Utils.base64String2Byte(downloadModel.getContent());
//        FileInputStream inputStream = new FileInputStream(new File("D:\\test.xlsx"));
//        byte[] buffer = new byte[inputStream.available()];
//        inputStream.read(buffer);
//
//
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer);
//        try {
//            OutputStream out = response.getOutputStream();
//            int i = byteArrayInputStream.read(buffer);
//            while (i != -1) {
//                out.write(buffer, 0, i);
//                i = byteArrayInputStream.read(buffer);
//            }
//            out.flush();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }

        RequestResult<List<DeviceSystemTypeDto>> requestResult = null ;
        List<DeviceSystemTypeDto> dataList = null ;

        requestResult = this.deviceService.getList(deviceQueryDto);
        if(requestResult == null  || (dataList = requestResult.getData()) == null || dataList.size() ==0)  {
            LOGGER.error("没有查询到下载的数据。。。。");
            return   ;
        }

        SXSSFWorkbook workbook = null;
        ServletOutputStream outputStream = null;

        try {
            ExcelExportDTO dto = new ExcelExportDTO() ;
            dto.setSheetName(systemType);
            dto.setSheetTitleArray(sheetTitleArray);
            dto.setExcelSheetBodyDataList(dataList);

            workbook = this.excelService.exportExcel(dto);
            if(workbook ==null ) {
                LOGGER.error(" 创建 excel 失败 ..................... ");
                return  ;
            }

            outputStream = response.getOutputStream();
            workbook.write(outputStream);
            outputStream.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                   e.printStackTrace();
                }
            }
            if(workbook != null) {
                workbook.dispose();
            }
        }
        long t4 = System.currentTimeMillis();
        LOGGER.info("excel  下载 完成， cost time =");
    }





}
