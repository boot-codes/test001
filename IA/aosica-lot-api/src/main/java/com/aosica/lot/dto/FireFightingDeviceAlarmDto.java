package com.aosica.lot.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/** 消防设备异常记录 dto
 * @PackgeName com.aosica.lot.dto
 * @ClassName FireFightingDeviceAlarmDto.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/25 21:02
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/25$ 21:02$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@ApiModel(value = "消防设备异常记录 dto")
@Data
public class FireFightingDeviceAlarmDto {

    @ApiModelProperty(value = "主健id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id ;

    @ApiModelProperty(value = "系统类型")
    private String systemType ;

    @ApiModelProperty(value = "设备类型")
    private String deviceType ;

    @ApiModelProperty(value = "设备id")
    private Long deviceId;

    @ApiModelProperty(value = "建筑物id")
    private Long buildingId ;

    @ApiModelProperty(value = "建筑物名称")
    private String buildingName ;

    @ApiModelProperty(value = "监管单位")
    private Long supervisionUnitId;

    @ApiModelProperty(value = "安装位置")
    private String installLocation;

    @ApiModelProperty(value = "安装楼层")
    private Integer installFloor;

    @ApiModelProperty(value = "状态")
    private Integer statue;

    @ApiModelProperty(value = "异常类型",example = "异常类型：( 正常:1，失联:2，告警:3，故障:4)")
    private Integer alarmType ;


    @ApiModelProperty(value = "是否已处理",example = "0 否, 1已处理, 2误报 ,3延期处理")
    private Integer isHandle;


    @ApiModelProperty(value = "发生异常时间")
    private String alarmTime;


    @ApiModelProperty(value = "处理时间")
    private Date handleTime ;




}
