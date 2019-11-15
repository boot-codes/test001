package com.aosica.agriculture.dto;

import com.aosica.lot.dto.AgricultureDeviceMetricalInfoDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * @program: ai-planting->EquipmentDto
 * @description: 设备信息实体
 * @author: dwj
 * @create: 2019-08-21 16:40
 **/
@Data
public class EquipmentExcelDto {
    /**
     * @Fields id
     **/
    //解决js精度丢失
    @JsonSerialize(using = ToStringSerializer.class)
    //@Excel(name = "序号", orderNum = "0")
    private long id;
    /**
     * @Fields 名称
     **/
   // @Excel(name = "设备名称", orderNum = "2")
    private String name;
    /**
     * @Fields 编号
     **/
    //@Excel(name = "设备编号", orderNum = "1")
    private String number;
    /**
     * @Fields 设备厂商
     **/
    //@Excel(name = "设备厂商", orderNum = "3")
    private String manufacturer;
    /**
     * @Fields 出厂日期
     **/
    //@Excel(name = "出厂日期", orderNum = "4")
    private String releaseDate;
    /**
     * @Fields 联网方式
     **/
    //@Excel(name = "联网方式", orderNum = "5")
    private int networkWay;
    /**
     * @Fields 接入方式
     **/
    //@Excel(name = "设备接入方式", orderNum = "6")
    private String accessWay;
    /**
     * @Fields 网关Id
     **/
   // @Excel(name = "网关Id", orderNum = "7")
    private String gatewayId;
    /**
     * @Fields 设备状态 (1 在线 2故障 3 离线 4报警)
     **/
    //@ExcelIgnore
    private int status;
    /**
     * @Fields 设备类型
     **/
    //@Excel(name = "设备类型", orderNum = "8")
    private int type;

    /**
     * @Fields 设备图片
     **/
    //@Excel(name = "设备图片", type = 2 ,width = 40 , height = 20,imageType = 1)
    private int img;

    /**
     * @Fields 设备类型名
     **/
   // @ExcelIgnore
    private String typeName;
    /**
     * @Fields 设备安装位置
     **/
    //@Excel(name = "设备安装位置", orderNum = "11")
    private long siteId;
    /**
     * @Fields 设备安装位置
     **/
    //@Excel(name = "设备安装位置", orderNum = "12")
    private String site;
    /**
     * @Fields 设备安装坐标
     **/
    //@Excel(name = "设备安装坐标", orderNum = "13")
    private String installCoordinate;
    /**
     * @Fields 设备安装详细位置
     **/
   // @Excel(name = "设备安装详细位置", orderNum = "14")
    private String installAddress;
    /**
     * @Fields 设备采集频率
     **/
    //@Excel(name = "设备采集频率", orderNum = "15")
    private float collectionFrequency;
    /**
     * @Fields 设备采集频率单位 月 month 天 day 小时 hour 分钟minute
     **/
    //@Excel(name = "设备采集频率单位", orderNum = "16")
    private String collectionFrequencyUnit;
    /**
     * @Fields 说明
     **/
    //@Excel(name = "说明", orderNum = "17")
    private String explain;
    /**
     * @Fields 设备是否在场(0 否 1是)
     **/
    //@Excel(name = "设备是否在场", orderNum = "18")
    private int isOnTheScene;

    /**
     * @Fields 设备是否删除(0 否 1是)
     **/
   // @Excel(name = "设备是否删除", orderNum = "18")
    private int isDelete;
    /**
     * @Fields 数据采集时间
     **/
   // @Excel(name = "数据采集时间", orderNum = "19")
    private String collectionTime;

    /**
     * @Fields 数据采集时间
     **/
   // @Excel(name = "数据采集时间2", orderNum = "20")
    private String collectionFrequencyStr;

    /**
     * @Fields 设备创建时间
     **/
   // @Excel(name = "设备创建时间", orderNum = "21")
    private String updateTimeStr;

    /**
     * @Fields 异常原因
     **/
   // @Excel(name = "异常原因", orderNum = "22")
    private String statusReason;

    /**
     * @Fields 设备状态
     **/
   // @Excel(name = "设备状态", orderNum = "23")
    private String statusStr;

    /**
     * @Fields 设备状态
     **/
   // @Excel(name = "测量监测项2", orderNum = "24")
    private MultipartFile[] files;

    /**
     * @Fields 测量监测项
     */
    //@ExcelIgnore
    private List<AgricultureDeviceMetricalInfoDto> MetricalInfoDtoList;
}
