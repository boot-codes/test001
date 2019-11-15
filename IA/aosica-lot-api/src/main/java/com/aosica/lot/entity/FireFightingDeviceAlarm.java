package com.aosica.lot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 消防设备异常报警实体类
 */
@Data
@ApiModel(value = "消防设备异常报警实体类")
public class FireFightingDeviceAlarm {

    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 工程id
     */
    @ApiModelProperty(value = "工程id")
    private String projectId ;

    /**
     * 设备id
     */
    @ApiModelProperty(value = "设备id")
    private Long deviceId ;

    @ApiModelProperty(value = "异常类型",example = "异常类型：( 正常:1，失联:2，告警:3，故障:4)")
    private Integer alarmType;

    @ApiModelProperty(value = "异常项")
    private String alarmItem;

    @ApiModelProperty(value = "异常值")
    private String alarmValue;

    @ApiModelProperty(value = "异常原因")
    private String alarmReason;

    @ApiModelProperty(value = "发生异常时间")
    private String alarmTime;

    @ApiModelProperty(value = "是否已处理",example = "0 否, 1已处理, 2误报 ,3延期处理")
    private Integer isHandle;

    @ApiModelProperty(value = "处理结果")
    private String handelResult;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    private String creater;

    @ApiModelProperty(value = "处理时间")
    private Date handleTime ;

    @ApiModelProperty(value = "处理人")
    private Long handler ;



}