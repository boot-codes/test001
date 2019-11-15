package com.aosica.fscp.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: ai-planting->QueryWater
 * @description: 查询水源信息DTO(接收)
 * @author: dwj
 * @create: 2019-10-30 17:22
 **/
@ApiModel(value = "查询水源信息DTO",description = "用于接收前端查询条件")
@Data
public class WaterQueryDto {

    @ApiModelProperty(value = "编号")
    private String number;

    @ApiModelProperty(value ="水源类型" ,example = "1河流 2湖泊 3人工湖 4消防水池")
    private int type;

    @ApiModelProperty(value = "页码")
    private int page = 1;

    @ApiModelProperty(value = "条数")
    private int pageSize = 10;

    @ApiModelProperty(value = "每页的第一条记录的索引")
    private int startIndex;

}
