package com.aosica.fscp.excel.dto;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 *  封装 excel 样式
 * @PackgeName com.aosica.common.export.excel
 * @ClassName ExcelStyle.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/10/11 16:38
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/10/11$ 16:38$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public class ExcelStyle {

    public static  Map<String ,CellStyle> cellStyleMap = new ConcurrentHashMap<>() ;

    public static  Map<String ,Font> fontMap = new ConcurrentHashMap<>() ;


    public static CellStyle getCellStyle(SXSSFWorkbook workbook , int type) {

        String md5Code = DigestUtils.md5Hex(String.valueOf(type).getBytes());
        if(cellStyleMap.containsKey(md5Code)) {
            return cellStyleMap.get(md5Code) ;
        }
        else {
            XSSFCellStyle cellStyle = (XSSFCellStyle) workbook.createCellStyle();
            // 单元格居中对齐格式
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            // 设置字体颜色：IndexedColors
            cellStyle.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
            cellStyle.setLocked(true);
            //自动换行
            cellStyle.setWrapText(true);
            // 设置背景色
//        cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.YELLOW.getIndex());
//        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // sheet 标题
            if (type == 1) {
                cellStyle.setFont(getFont(workbook, (short) 11, IndexedColors.ORANGE.index, true));
            } else {
                // excel body
                cellStyle.setFont(getFont(workbook, (short) 10, IndexedColors.BLACK.index, false));
            }
            cellStyleMap.put(md5Code, cellStyle) ;
            return cellStyle;
        }
    }


    /**
     * 创建字体及样式
     * @param
     * fontSize :字体大小
     * color ：颜色索引值。详见:IndexedColors
     * @return
     */
    public static Font getFont(SXSSFWorkbook workbook ,short fontSize ,short color ,boolean isBold) {

        StringBuilder stringBuilder = new StringBuilder() ;
        stringBuilder.append(fontSize).append(color).append(isBold) ;

        String md5Code = DigestUtils.md5Hex(stringBuilder.toString().getBytes());
        if(fontMap.containsKey(md5Code)) {
            return fontMap.get(md5Code) ;
        }
        else {
            Font font = workbook.createFont();
            // 设置字体的大小
            font.setFontHeightInPoints(fontSize);
            //设置字体颜色
            font.setColor(color);
            // 字体加粗
            font.setBold(isBold);
            fontMap.put(md5Code, font) ;
            return font ;
        }
    }

}
