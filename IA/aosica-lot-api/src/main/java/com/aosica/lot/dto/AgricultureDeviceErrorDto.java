package com.aosica.lot.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @program: ai-planting->EquipmentErrorDto
 * @description: 设备报警dto
 * @author: dwj
 * @create: 2019-09-02 14:42
 **/
@Data
public class AgricultureDeviceErrorDto {

    /**
     * @Fields id
     **/
    //解决js精度丢失
    @JsonSerialize(using = ToStringSerializer.class)
    private long id;
    /**
     * @Fields 设备Id
     **/
    private String equipmentId;
    /**
     * @Fields 异常类型(2故障 3 离线 4报警)
     **/
    private int  errorType;
    /**
     * @Fields 异常数据
     **/
    private String errorValue;
    /**
     * @Fields 异常数据名
     **/
    private String errorName;
    /**
     * @Fields 异常原因
     **/
    private String errorReason;
    /**
     * @Fields 采集时间
     **/
    private String collectionTime;
    /**
     * @Fields 是否处理  0 否 1已处理 2误报 3延期处理
     **/
    private int isHandel;

    /**
     * @Fields 处理意见
     **/
    private String handelResult;
    /**
     * @Fields 安装位置
     **/
    private String installAdress;

    /**
     * @Fields  厂商
     **/
    private String manufacturer;

    /**
     * @Fields 出厂日期
     **/
    private String releaseDate;

    /**
     * @Fields 设备类型
     **/
    private String typeName;

    /**
     * @Fields 设备安装位置
     **/
    private String site;

    /**
     * @Fields 设备安装坐标
     **/
    private String installCoordinate;

    /**
     * @Fields 设备名
     **/
    private String name;
    /**
     * @Fields 设备编号
     **/
    private String number;


}
