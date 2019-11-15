package com.aosica.fscp.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @program: ai-planting->QueryWaterListDto
 * @description: 查询水源信息结果
 * @author: dwj
 * @create: 2019-10-30 17:33
 **/
@ApiModel(value = "查询水源信息结果Dto",description = "用于返回查询结果")
public class QueryWaterListDto {

    @ApiModelProperty(value = "id")
    private long id;

    @ApiModelProperty(value = "编号")
    private String number;

    @ApiModelProperty(value ="水源类型" ,example = "1河流 2湖泊 3人工湖 4消防水池")
    private int type;

    @ApiModelProperty(value = "储水量")
    private String waterCapacity;

    @ApiModelProperty(value = "水位")
    private String waterLevel;

    @ApiModelProperty(value = "责任人")
    private String manager;

    @ApiModelProperty(value = "责任人电话")
    private String mobile;

    @ApiModelProperty(value = "管理单位")
    private String managementUnit;

}
