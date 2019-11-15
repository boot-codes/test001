package com.aosica.lot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: ai-planting->Equipment
 * @description: 智慧农业设备实体
 * @author: dwj
 * @create: 2019-08-22 19:35
 **/
@ApiModel(description = "智慧农业设备实体")
@Data
public class AgricultureDevice {

    @ApiModelProperty(value = "设备Id")
    private long id;

    @ApiModelProperty(value = "设备名称")
    private String name;

    @ApiModelProperty(value = "设备编号")
    private String number;

    @ApiModelProperty(value = "设备生产厂商")
    private String manufacturer;

    @ApiModelProperty(value = "出场日期")
    private String releaseDate;

    @ApiModelProperty(value = "联网方式(1wifi, 2 4G,3 5G,4 有线传输，5 NB-LOT,6 以太网)")
    private int networkWay;

    @ApiModelProperty(value = "设备接入方式(1 HTTP,2 EDP,3 MOTT,4 Modbus,5 JT/T808,6 TCP透传)")
    private String accessWay;

    @ApiModelProperty(value = "网关Id")
    private String gatewayId;

    @ApiModelProperty(value = "设备状态 (1 在线 2故障 3 离线 4报警)")
    private int status;

    @ApiModelProperty(value = "设备类型")
    private String typeName;

    @ApiModelProperty(value = "设备安装位置")
    private String site;

    @ApiModelProperty(value = "设备安装坐标")
    private String installCoordinate;

    @ApiModelProperty(value = "设备安装详细位置")
    private String installAddress;

    @ApiModelProperty(value = "设备采集频率")
    private float collectionFrequency;

    @ApiModelProperty(value = "设备采集频率单位 月 month 天 day 小时 hour 分钟minute")
    private String collectionFrequencyUnit;

    @ApiModelProperty(value = "说明")
    private String explain;


}
