package com.aosica.lot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 *  消防设备实体类
 */
@Data
@ApiModel(description = "消防设备实体类")
public class FireFightingDevice {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "工程id")
    private Long projectId;

    @ApiModelProperty(value = "系统类型")
    private String systemType;

    @ApiModelProperty(value = "设备类型")
    private String deviceType;

    @ApiModelProperty(value = "设备id")
    private Long deviceId;

    @ApiModelProperty(value = "经度")
    private String longitude;

    @ApiModelProperty(value = "纬度")
    private String latitude;

    @ApiModelProperty(value = "安装位置")
    private String installLocation;

    @ApiModelProperty(value = "建筑物id")
    private Long buildingId;

    @ApiModelProperty(value = "建筑物名称")
    private String buildingName;

    @ApiModelProperty(value = "安装楼层")
    private Integer installFloor;

    @ApiModelProperty(value = "关联单位id")
    private Long associatedUnitId;

    @ApiModelProperty(value = "关联单位名称")
    private String associatedUnitName ;

    @ApiModelProperty(value = "监管单位 id")
    private Long supervisionUnitId;

    @ApiModelProperty(value = "监管单位名称")
    private String supervisionUnitName ;

    @ApiModelProperty(value = "父设备id")
    private Long parentId ;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "创建人")
    private Long creater;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    @ApiModelProperty(value = "更新人")
    private Long updater;

    @ApiModelProperty(value = "设备状态",notes = "1:正常，2:失联，3:告警，4:故障")
    private Integer statue;


}