package com.aosica.fscp.export.excel.dto;

import lombok.Data;

/**
 * 每一个excel cell 显示的内容，通过 ExcelCellData 对象来进封装。
 * @PackgeName com.aosica.common.export.excel.dto
 * @ClassName ExcelCellData.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/10/11 17:48
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/10/11$ 17:48$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@Data
public class ExcelCellData {

    /**
     * 单元格的内容
     */
    private Object data ;

    /**
     * 单元格内容的数据类型
     */
    private int dataType ;


    public ExcelCellData() {
    }

    public ExcelCellData(Object data, int dataType) {
        this.data = data;
        this.dataType = dataType;
    }
}
