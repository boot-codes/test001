package com.aosica.lot.dto;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 设备异常记录 DTO
 * @PackgeName com.aosica.lot.dto
 * @ClassName DeviceAbnormalRecordDto.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/10/8 19:55
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/10/8$ 19:55$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@Data
@Api(value = "设备异常记录DTO")
public class DeviceAbnormalRecordDto {


    @ApiModelProperty(value = "主键id")
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
     * 上报时间
     */
    @ApiModelProperty(value = "上报时间")
    private Date upperDate ;


    /**
     * 设备处理时间
     */
    @ApiModelProperty(value = "设备处理时间")
    private Date updateDate ;
}
