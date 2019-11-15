package com.aosica.lot.controller;

import com.aosica.lot.dto.DeviceSystemTypeDto;
import com.aosica.lot.dto.FireFightingDeviceQueryDto;
import com.aosica.lot.service.FireFightingDeviceService;
import com.github.pagehelper.Page;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * @PackgeName com.aosica.lot.controller
 * @ClassName TestExcelExportController.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/10/12 17:43
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/10/12$ 17:43$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@Controller
public class TestExcelExportController {


    private static final String[][] sheetTitleArray = {{"系统类型","4500"},{"设备类型","2500"}
            ,{"设备id","4500"},{"建筑物名称","4500"},{"监管单位","5500"},{"安装位置","4500"},{"设备状态","4500"},{"设备处理时间","4500"}} ;


    @Autowired
    private FireFightingDeviceService fireFightingDeviceService ;


//    @Autowired
//    private ExcelService excelService ;



    @RequestMapping("/excel/export")
    public void excelExport(HttpServletResponse response) throws Exception{

        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("test.xls", "UTF-8"));

        FireFightingDeviceQueryDto deviceQueryDto = new FireFightingDeviceQueryDto() ;
        deviceQueryDto.setParentId(1000L);
        // 设置导出的条数
        deviceQueryDto.setPageSize(1000);
        // 当只导出指定的id时数据时。
        //deviceQueryDto.setFbk("335356683625152512,335946275818553344,335947445127593984");
        //Page<DeviceSystemTypeDto> page = this.fireFightingDeviceService.getListByCondition(deviceQueryDto);

        SXSSFWorkbook workbook = null;
        ServletOutputStream outputStream = null;
        try {
            //workbook = this.excelService.exportExcel("test", sheetTitleArray, page.getResult());
            outputStream = response.getOutputStream();
            workbook.write(outputStream);
            outputStream.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(outputStream != null) {
                outputStream.close();
            }
            if(workbook != null) {
                workbook.dispose();
            }
        }

        long t4 = System.currentTimeMillis();
        System.out.println("excel  下载 cost time ");

    }

}
