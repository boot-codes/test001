package com.aosica.lot.test;


import com.aosica.lot.api.FireFightingDeviceApi;
import com.aosica.lot.dto.FireFightingDeviceQueryDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
//    private FireFightingDeviceService fireFightingDeviceService ;


    @Autowired
    FireFightingDeviceApi fireFightingDeviceApi ;




    @Test
    public void excelExport() throws Exception {
        FireFightingDeviceQueryDto deviceQueryDto = new FireFightingDeviceQueryDto() ;
        deviceQueryDto.setProjectId("1000");
        deviceQueryDto.setPageSize(5);
        // 当只导出指定的id时数据时。
//        deviceQueryDto.setFbk("335356683625152512,335946275818553344,335947445127593984");
        //RequestResultPage<Page<DeviceSystemTypeDto>> list = this.fireFightingDeviceApi.getList(deviceQueryDto);

        //Page<DeviceSystemTypeDto> data = list.getData();

        //System.out.println();

        //this.excelService.exportExcel("test", sheetTitleArray ,page.getResult());
    }









}
