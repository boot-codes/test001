package com.aosica.fscp.excel.dto;

import lombok.Data;

/**
 * 封装 excel 标题。
 * @PackgeName com.aosica.common.export.excel.dto
 * @ClassName ExcelSheetHead.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/10/11 15:51
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/10/11$ 15:51$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@Data
public class ExcelSheetHead {


    /**
     * sheet 标题名称
     */
    private String headName ;


    /**
     *  列宽
     */
    private int columnSize ;


    public ExcelSheetHead(String headName, int columnSize) {
        this.headName = headName;
        this.columnSize = columnSize;
    }


}
