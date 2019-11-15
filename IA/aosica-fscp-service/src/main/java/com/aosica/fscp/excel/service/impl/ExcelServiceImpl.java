package com.aosica.fscp.excel.service.impl;


import com.aosica.common.util.ObjectUtil;
import com.aosica.fscp.excel.dto.ExcelCellData;
import com.aosica.fscp.excel.dto.ExcelExportDTO;
import com.aosica.fscp.excel.dto.ExcelSheetHead;
import com.aosica.fscp.excel.dto.ExcelStyle;
import com.aosica.fscp.excel.service.ExcelService;
import com.aosica.lot.dto.DeviceSystemTypeDto;
import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * @PackgeName com.aosica.common.export.excel.service.impl
 * @ClassName ExcelServiceImpl.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/10/12 11:55
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/10/12$ 11:55$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@Service
public class ExcelServiceImpl implements ExcelService {



    /**
     * excel 导出 的入口
     *
//     * @param sheetName :sheet 的名称
//     * @param sheetTitleArray : sheet 标题
//     * @param excelSheetBodyDataList  sheet body 的内容
     */
    @Override
    public SXSSFWorkbook exportExcel(ExcelExportDTO dto) throws Exception {

        ObjectUtil.checkNonEmpty(dto.getSheetTitleArray()," excel 标题不能为空") ;
        ObjectUtil.checkNonEmpty(dto.getExcelSheetBodyDataList()," excel body 不能为空") ;
//
        long t1 = System.currentTimeMillis();
        SXSSFWorkbook workbook = new SXSSFWorkbook(200) ;
        SXSSFSheet sheet = workbook.createSheet(dto.getSheetName());
//
//        //创建excel sheet 标题
        createExcelSheetHead(workbook,sheet,getExcelSheetHead(dto.getSheetTitleArray()));
//
//        //写 excel body 的内容
        writeExcelBodyData(workbook,sheet , toExcelCellDataList(dto.getExcelSheetBodyDataList())) ;
        long t2 = System.currentTimeMillis();
        System.out.println("创建 excel cost time(ms) :" +(t2-t1));
        return workbook ;
    }


    @Override
    public  List<List<ExcelCellData>> toExcelCellDataList(List<DeviceSystemTypeDto> dataList) {

        List<List<ExcelCellData>> excelCellDataList = new ArrayList<>();

        for (int n = 0; n < dataList.size(); n++) {
           try {
                List<ExcelCellData> propertyList = getPropertyList(dataList.get(n));
                excelCellDataList.add(propertyList);
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        return excelCellDataList;
    }


    @Override
    public List<ExcelCellData> getPropertyList(DeviceSystemTypeDto deviceSystemTypeDto) throws Exception {

        LinkedList<ExcelCellData> list = new LinkedList() ;
        Field[] fields = deviceSystemTypeDto.getClass().getDeclaredFields();

        for (Field field :fields) {

            field.setAccessible(true);
            String name = field.getName();
            if("id".equals(name)) {
                continue;
            }
            Object value = field.get(deviceSystemTypeDto);
            String type = field.getType().getSimpleName();

            ExcelCellData cellData = new ExcelCellData() ;
            cellData.setData(value);
            cellData.setDataType(JavaDataType.getDataTypeId(type));
            list.add(cellData) ;
        }

        return  list ;
    }


    /**
     * 创建单元格，并设置单元格的内容
     * @param workbook
     * @param row
     * @param index
     * @param head
     * @return
     */
    public SXSSFCell createShellCell(SXSSFWorkbook workbook, SXSSFSheet sheet, SXSSFRow row, int index, ExcelSheetHead head){
        SXSSFCell cell = row.createCell(index);
        cell.setCellValue(head.getHeadName());
        cell.setCellStyle(ExcelStyle.getCellStyle(workbook,1));
        sheet.setColumnWidth(index,head.getColumnSize());
        return cell ;
    }


    /**
     *  获取sheet 标题
     * @return
     */
    public List<ExcelSheetHead> getExcelSheetHead(String[][] title) {

        List<ExcelSheetHead> excelSheetHeadList = new LinkedList<>() ;

        for (int i=0 ;i<title.length ;i++) {
            String titleName =  title[i][0] ;
            String columnSize =  title[i][1] ;
            excelSheetHeadList.add(new ExcelSheetHead(titleName,Integer.valueOf(columnSize))) ;
        }
        return excelSheetHeadList ;
    }



    /**
     * 写 excel 标题
     * @param excelSheetHeadList
     */
    private void createExcelSheetHead(SXSSFWorkbook workbook ,SXSSFSheet sheet , List<ExcelSheetHead> excelSheetHeadList) {

        SXSSFRow row = sheet.createRow(0);
        for (int i=0 ;i<excelSheetHeadList.size() ;i++) {
            ExcelSheetHead excelSheetHead = excelSheetHeadList.get(i);
            createShellCell(workbook,sheet, row,i, excelSheetHead) ;
        }
    }


    /**
     * 写入excel 内容
     */
    private void writeExcelBodyData(SXSSFWorkbook workbook ,SXSSFSheet sheet ,List<List<ExcelCellData>> data) {

        for (int i=0 ;i<data.size() ;i++){
            SXSSFRow row = sheet.createRow(i + 1);
            List<ExcelCellData> cellDataList = data.get(i);
            for(int j=0 ;j<cellDataList.size() ;j++) {

                SXSSFCell cell = row.createCell(j);
                cell.setCellStyle(ExcelStyle.getCellStyle(workbook,2));

                ExcelCellData excelCellData = cellDataList.get(j);
                Object value = excelCellData.getData();
                int dataType = excelCellData.getDataType();

                if(dataType ==1 || dataType ==2 || dataType==3 || dataType ==4) {
                    cell.setCellValue(String.valueOf(value));
                }
                else if(dataType ==7) {
                    cell.setCellValue((String)value);
                }
            }
        }
    }




    static  class JavaDataType {

        private static final Map<String, Integer> dataMap = new HashedMap() ;

        static {
            dataMap.put("Integer",1) ;
            dataMap.put("int",1) ;

            dataMap.put("Long",2) ;
            dataMap.put("long",2) ;

            dataMap.put("Short",3) ;
            dataMap.put("short",3) ;

            dataMap.put("Double",4) ;
            dataMap.put("double",4) ;

            dataMap.put("Float",5) ;
            dataMap.put("float",5) ;

            dataMap.put("Byte",6) ;
            dataMap.put("byte",6) ;

            dataMap.put("String",7) ;
            dataMap.put("Date",7) ;
        }


        public static int getDataTypeId(String dataType) {
            // 如果没有获到对应的数据类型，则默认返回为String类型。确保返回不为空
            Integer dataTypId = dataMap.get(dataType)==null ? 7: dataMap.get(dataType);
            return  dataTypId ;
        }

    }







}
