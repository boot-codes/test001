package com.aosica.lot.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @PackgeName com.aosica.lot.dto
 * @ClassName DeviceSystemTypeDto.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/23 17:49
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/23$ 17:49$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@Data
@ApiModel(value = "设备系统类型DTO")
public class DeviceSystemTypeDto {


    @ApiModelProperty(value = "id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id ;


    /**
     * 系统类型
     */
    @ApiModelProperty(value = "系统类型")
    private String systemType ;

    /**
     * 设备类型
     */
    @ApiModelProperty(value = "设备类型")
    private String deviceType ;

    /**
     * 设备id
     */
    @ApiModelProperty(value = "设备id")
    private String deviceId ;


    /**
     * 建筑物名称
     */
    @ApiModelProperty(value = "建筑物名称")
    private String buildingName ;


    /**
     * 监管单位
     */
    @ApiModelProperty(value = "监管单位")
    private String associatedUnit;


    /**
     * 安装位置
     */
    @ApiModelProperty(value = "安装位置")
    private String installLocation ;

    /**
     * 设备状态
     */
    @ApiModelProperty(value = "设备状态")
    private int statue ;

    /**
     * 设备处理更新时间
     */
    @ApiModelProperty(value = "设备处理更新时间")
    private Date updateDate ;



}
