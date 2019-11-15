package com.aosica.fscp.export.excel.service;


import com.aosica.fscp.export.excel.dto.ExcelCellData;
import com.aosica.fscp.export.excel.dto.ExcelExportDTO;
import com.aosica.lot.dto.DeviceSystemTypeDto;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.util.List;

/**
 *
 * @PackgeName com.aosica.common.export.excel.service
 * @ClassName ExcelService.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/10/12 11:53
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/10/12$ 11:53$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public interface ExcelService {


    /**
     * excel 导出
     * @param sheetName :sheet的名字
     * @param sheetTitleArray sheet 标题
     * @param excelSheetBodyDataList excel body 内容
     */
    SXSSFWorkbook exportExcel(ExcelExportDTO dto) throws Exception ;

    List<List<ExcelCellData>> toExcelCellDataList(List<DeviceSystemTypeDto> dataList) ;


    List<ExcelCellData> getPropertyList(DeviceSystemTypeDto object) throws Exception ;

}
