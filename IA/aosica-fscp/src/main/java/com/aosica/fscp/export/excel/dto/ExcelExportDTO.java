package com.aosica.fscp.export.excel.dto;

import com.aosica.lot.dto.DeviceSystemTypeDto;
import lombok.Data;

import java.util.List;

/**
 * @PackgeName com.aosica.fscp.api.dto
 * @ClassName ExcelExportDTO.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/10/15 10:09
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/10/15$ 10:09$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@Data
public class ExcelExportDTO {

    private String sheetName ;
    private String[][] sheetTitleArray ;
    private List<DeviceSystemTypeDto> excelSheetBodyDataList ;

    //private List<List<ExcelCellData>>  excelSheetBodyDataList ;

}
