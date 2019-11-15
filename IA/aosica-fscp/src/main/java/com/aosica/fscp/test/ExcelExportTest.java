package com.aosica.fscp.test;


import com.aosica.fscp.export.excel.service.ExcelService;
import com.aosica.lot.dto.DeviceSystemTypeDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackgeName com.aosica.lot.test
 * @ClassName ExcelExportTest.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/10/12 12:01
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/10/12$ 12:01$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelExportTest {


    private static final String[][] sheetTitleArray = {{"系统类型","4500"},{"设备类型","4500"}
     ,{"设备id","4500"},{"建筑物名称","4500"},{"监管单位","5500"},{"安装位置","4500"},{"设备状态","4500"},{"设备处理时间","4500"}} ;


//    @Autowired
//    private DeviceService deviceService ;

//    @Autowired
//    private FscpExcelService excelService ;

    @Autowired
    private ExcelService excelService  ;



    @Test
    public void excelExport() throws Exception {
//        FireFightingDeviceQueryDto deviceQueryDto = new FireFightingDeviceQueryDto() ;
//        deviceQueryDto.setParentId(1000L);
//        deviceQueryDto.setPageSize(10);
        // 当只导出指定的id时数据时。
        //deviceQueryDto.setFbk("335356683625152512,335946275818553344,335947445127593984");
//        RequestResult<Page<DeviceSystemTypeDto>> requestResult = this.deviceService.getListByCondition(deviceQueryDto);
//        Page<DeviceSystemTypeDto> page = requestResult.getData();
//        List<DeviceSystemTypeDto> dataList = page.getResult();

        List<DeviceSystemTypeDto> dataList = new ArrayList<>() ;

        DeviceSystemTypeDto deviceSystemTypeDto = new DeviceSystemTypeDto() ;
        deviceSystemTypeDto.setId(1111L);
        deviceSystemTypeDto.setDeviceType("电气火灾自动报警系统");
        deviceSystemTypeDto.setDeviceId("1111111111");
        dataList.add(deviceSystemTypeDto) ;

//        List<ExcelCellData> propertyList = this.excelService.getPropertyList(deviceSystemTypeDto, DeviceSystemTypeDto.class);
//        System.out.println(propertyList);


//        ExcelExportDTO dto = new ExcelExportDTO() ;
//        dto.setSheetName("test");
//        dto.setUserName("yuzp");
//        dto.setSheetTitleArray(sheetTitleArray);
//        dto.setExcelSheetBodyDataList(dataList);


//        SXSSFWorkbook workbook = this.excelService.exportExcel(dto);

    }









}
