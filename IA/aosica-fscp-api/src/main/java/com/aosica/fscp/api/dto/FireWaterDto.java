package com.aosica.fscp.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @program: ai-planting->fireWaterDto
 * @description: 消防水源信息
 * @author: liuli
 * @create: 2019-10-30 15:41
 **/
@ApiModel(value = "消防水源信息")
public class FireWaterDto {

    @ApiModelProperty(value = "id")
    private long id;

    @ApiModelProperty(value ="水源类型" ,example = "1河流 2湖泊 3人工湖 4消防水池")
    private int type;

    @ApiModelProperty(value = "编号")
    private String number;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "水位")
    private String waterLevel;

    @ApiModelProperty(value = "储水量")
    private String waterCapacity;

    @ApiModelProperty(value = "水源地址")
    private String waterAddress;

    @ApiModelProperty(value = "档案编号")
    private String fileNumber;

    @ApiModelProperty(value = "责任人")
    private String manager;

    @ApiModelProperty(value = "责任人电话")
    private String mobile;

    @ApiModelProperty(value = "所属区域")
    private String belongArea;

    @ApiModelProperty(value = "管理单位")
    private String managementUnit;

    @ApiModelProperty(value = "经度")
    private String longitude;

    @ApiModelProperty(value = "纬度")
    private String latitude;

    @ApiModelProperty(value = "地理位置")
    private String location;

    @ApiModelProperty(value = "服务名称")
    private String serviceName;

    @ApiModelProperty(value = "项目Id")
    private String projectId;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

}
