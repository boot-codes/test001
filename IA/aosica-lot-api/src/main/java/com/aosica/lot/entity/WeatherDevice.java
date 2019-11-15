package com.aosica.lot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 气象设备管理元素实体类
 */

@ApiModel(description = "气象设备管理元素实体类")
@Data
public class WeatherDevice {


    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 工程 id
     */
    @ApiModelProperty(value = "工程 id")
    private String projectId;

    /**
     * 设备id
     */
    @ApiModelProperty(value = "设备id")
    private String deviceId;


    /**
     * 设备型号
     */
    @ApiModelProperty(value = "设备型号")
    private String deviceModel;

    /**
     * 风速  m/s
     */
    @ApiModelProperty(value = "风速  m/s")
    private Double windSpeed;

    /**
     * 风向
     */
    @ApiModelProperty(value = "风向")
    private Float windDirection;

    /**
     *  温度
     */
    @ApiModelProperty(value = "温度")
    private Float temperature;


    /**
     *  湿度
     */
    @ApiModelProperty(value = "湿度")
    private Float humidity;

    /**
     *  雨量
     */
    @ApiModelProperty(value = "雨量")
    private Float rainfall;

    /**
     *  光照
     */
    @ApiModelProperty(value = "光照")
    private Float illumination;


    /**
     *  大气压压力
     */
    @ApiModelProperty(value = "大气压压力")
    private Float atmosphericPressure;

    /**
     *  采集时间
     */
    @ApiModelProperty(value = "采集时间")
    private Date collectorDate;

    /**
     *  备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;



}