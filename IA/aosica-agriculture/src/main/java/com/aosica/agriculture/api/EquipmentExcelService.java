package com.aosica.agriculture.api;

import com.aosica.common.bean.RequestResult;
import com.aosica.lot.dto.AgricultureDeviceDto;
import com.aosica.lot.vo.AgricultureDeviceVo;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @program: ai-planting->EquipmentService
 * @description: 设备接口实现类
 * @author: Windows10
 * @create: 2019-08-22 17:11
 **/
@Service
public class EquipmentExcelService implements EquipmentExcelApi {

//    @Autowired
//    private EquipmentMapper equipmentMapper;

    @Autowired
    AgricultureDeviceService agricultureDeviceService ;

//    @Autowired
//    private FileService fileService;


    @Override
    public void export(HttpServletRequest request, HttpServletResponse response, Integer startIndex, Integer rowNum, String status, String name) throws IOException {
        RequestResult requestResult = null;
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("设备批量导出表");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell = row1.createCell(0);
        //设置单元格内容
        cell.setCellValue("序号");
        cell = row1.createCell(1);
        //设置单元格内容
        cell.setCellValue("设备编号");
        cell = row1.createCell(2);
        //设置单元格内容
        cell.setCellValue("设备名称");

        cell = row1.createCell(3);
        //设置单元格内容
        cell.setCellValue("设备厂商");

        cell = row1.createCell(4);
        //设置单元格内容
        cell.setCellValue("出厂日期");

        cell = row1.createCell(5);
        //设置单元格内容
        cell.setCellValue("联网方式");

        cell = row1.createCell(6);
        //设置单元格内容
        cell.setCellValue("设备接入方式");

        cell = row1.createCell(7);
        //设置单元格内容
        cell.setCellValue("网关id");

        cell = row1.createCell(8);
        //设置单元格内容
        cell.setCellValue("设备类型");

        cell = row1.createCell(9);
        //设置单元格内容
        cell.setCellValue("设备图片");

        cell = row1.createCell(10);
        //设置单元格内容
        cell.setCellValue("设备安装位置");

        cell = row1.createCell(11);
        //设置单元格内容
        cell.setCellValue("设备安装坐标");

        cell = row1.createCell(12);
        //设置单元格内容
        cell.setCellValue("设备安装地址");

        cell = row1.createCell(13);
        //设置单元格内容
        cell.setCellValue("数据采集频率");

        cell = row1.createCell(14);
        //设置单元格内容
        cell.setCellValue("说明");

        HashMap<String, Object> map = new HashMap<>();
        map.put("startIndex", startIndex);
        map.put("rowNum", rowNum);
        map.put("status", status);
        map.put("name", name);
        AgricultureDeviceVo equipmentVo = agricultureDeviceService.listAgricultureDevice(map);
        List<AgricultureDeviceDto> list = null  ;
        if(equipmentVo == null  || (list = equipmentVo.getList()) == null) {
            return   ;
        }


        //创建单元格并设置单元格内容
        for (int i = 0; i < list.size(); i++) {
            //在sheet里创建第二行
            HSSFRow row2 = sheet.createRow(i + 1);
            row2.createCell(0).setCellValue(list.get(i).getId());
            row2.createCell(1).setCellValue(list.get(i).getNumber());
            row2.createCell(2).setCellValue(list.get(i).getName());
            row2.createCell(3).setCellValue(list.get(i).getManufacturer());
            row2.createCell(4).setCellValue(list.get(i).getReleaseDate());
            row2.createCell(5).setCellValue(list.get(i).getNetworkWay());
            row2.createCell(6).setCellValue(list.get(i).getAccessWay());
            row2.createCell(7).setCellValue(list.get(i).getGatewayId());
            row2.createCell(8).setCellValue(list.get(i).getType());
            HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 255, 255, (short) 9, i + 1, (short) 9, i + 1);
            // 图片字节流
            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
            File file = ResourceUtils.getFile("classpath:6239936_092702973000_2.jpg");
            //获取文件的相对路径  可在控制台打印查看输出结果
            String filePath = ResourceUtils.getFile("classpath:6239936_092702973000_2.jpg").getPath();
            BufferedImage bufferImg = ImageIO.read(new File(filePath));
            ImageIO.write(bufferImg, "jpg", byteArrayOut);
            byte[] imgtypes = byteArrayOut.toByteArray();
            int puctureIndex = wb.addPicture(imgtypes, HSSFWorkbook.PICTURE_TYPE_JPEG);
            // 创建图片
            patriarch.createPicture(anchor, puctureIndex);
            row2.createCell(10).setCellValue(list.get(i).getSite());
            row2.createCell(11).setCellValue(list.get(i).getInstallCoordinate());
            row2.createCell(12).setCellValue(list.get(i).getInstallAddress());
            row2.createCell(13).setCellValue(list.get(i).getCollectionFrequency());
            row2.createCell(14).setCellValue(list.get(i).getExplain());
        }

        //输出Excel文件
        OutputStream output = response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=details.xls");
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
    }

    @Override
    public void importExcel(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        int error = 0;
        int success = 0;
        //使用POI解析Excel文件
        //如果是xls，使用HSSFWorkbook；2003年的excel  如果是xlsx，使用XSSFWorkbook  2007年excel
        Workbook workbook;
        Sheet sheet;
        try {
            workbook = new HSSFWorkbook(file.getInputStream());
        } catch (Exception e) {
            workbook = new XSSFWorkbook(file.getInputStream());
        }
        //6.1创建字体
        Font font = workbook.createFont();
        font.setColor(Font.COLOR_RED);
        //6.2创建单元格格式CellStyle
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {//获取每个Sheet表
            sheet = workbook.getSheetAt(i);
            for (Row row : sheet) {
                int sum = 0;
                int rowNum = row.getRowNum();
                if (rowNum == 0) {//跳出第一行   一般第一行都是表头没有数据意义
                    continue;
                }
                if (row.getCell(0) != null) {//第2列数据
                    //row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                    Map<String, Object> map = new HashMap<>();
                    map.put("number", row.getCell(0).getStringCellValue().trim());
                    AgricultureDeviceDto equipmentDto = agricultureDeviceService.selectById(map);
                    if (equipmentDto == null) {
                        error++;
                        i++;
                        Cell cell = row.createCell(2);
                        cell.setCellValue("设备编号不存在");
                        //6.3字体作用单元格
                        cell.setCellStyle(cellStyle);
                        continue;
                    }
                    if (row.getCell(1) != null) {
                        //row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                        equipmentDto.setExplain(row.getCell(1).getStringCellValue().trim());
                        //修改接口
                        //equipmentMapper.update(equipmentDto);
                    }
                }
                if (sum == 0) {
                    success++;
                }
            }
        }

        if (error > 0) {
            //输出Excel文件
            OutputStream output = response.getOutputStream();
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename=error.xls");
            response.addHeader("error", error + "");
            response.addHeader("success", success + "");
            response.setContentType("application/msexcel");
            workbook.write(output);
            output.close();
        }
    }

    @Override
    public void downloadExcel(HttpServletResponse response) throws FileNotFoundException, UnsupportedEncodingException {
        String fileName = "设备导入模板.xlsx";// 设置文件名，根据业务需要替换成要下载的文件名
        if (fileName != null) {
            //设置文件路径
            File file = ResourceUtils.getFile("classpath:templates/设备导入模板.xlsx");
            //获取文件的相对路径  可在控制台打印查看输出结果
            String filePath = ResourceUtils.getFile("classpath:templates/设备导入模板.xlsx").getPath();
            if (file.exists()) {
                //下载文件
                String filename = "设备导入模板.xlsx";// 设置文件名，根据业务需要替换成要下载的文件名
                String filename_ = new String(filename.getBytes("GBK"), "ISO8859_1");
                response.setHeader("Cache-Control", "must-revalidate");
                response.setHeader("Cache-Control", "post-check=0");
                response.setHeader("Cache-Control", "pre-check=0");
                response.setCharacterEncoding("utf-8");
                response.setContentType("multipart/form-data");
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + filename_);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}



