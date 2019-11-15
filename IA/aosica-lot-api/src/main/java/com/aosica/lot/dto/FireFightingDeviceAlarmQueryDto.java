package com.aosica.lot.dto;


import com.aosica.common.annotation.SpecialCharacterCheck;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 查询消防设备报警历记录DTO
 */

@Data
@ApiModel(description = "查询消防设备报警历记录DTO")
public class FireFightingDeviceAlarmQueryDto {


    @ApiModelProperty(value = "分页页数",required = true)
    private int pageNum =0 ;

    @ApiModelProperty(value = "每页显示的条数",required = true)
    private int pageSize=10 ;

    @NotNull
    @ApiModelProperty(value = "工程id")
    private String projectId ;

    @ApiModelProperty(value = "设备类型")
    private String deviceType;


    @ApiModelProperty(value = "设备id")
    @SpecialCharacterCheck
    private Long deviceId ;


    @ApiModelProperty(value = "系统类型名称")
    private String systemType;



    @ApiModelProperty(value = "建筑物名称")
    @SpecialCharacterCheck
    private String buildingName;


    @ApiModelProperty(value = "监管单位名称")
    @SpecialCharacterCheck
    private Long supervisionUnit;

    @ApiModelProperty(value = "异常类型")
    private Integer alarmType ;


}
