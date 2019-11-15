package com.aoscia.base.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @program: ai-planting->FireWaterDto
 * @description: 消防水源Dto
 * @author: ll
 * @create: 2019-11-05 10:37
 **/

@Data
@ToString
@ApiModel(value = "查询消防水源DTO")
public class FireWaterDto {

    //公共属性
    @ApiModelProperty(value = "分页页数",required = true)
    private int pageNum =0 ;

    @ApiModelProperty(value = "每页显示的条数",required = true)
    private int pageSize=10 ;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime ;


    @NotNull
    @ApiModelProperty(value = "工程id",required = true)
    private String projectId ;




    //一般属性
    /**
     * @Fields id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * @Fields 1河流 2湖泊 3人工湖 4消防水池
     */
    private int type;
    /**
     * @Fields  编号
     */
    private String number;

    /**
     * @Fields  水位
     */
    private String waterLevel;
    /**
     * @Fields  储水量
     */
    private String waterCapacity;
    /**
     * @Fields  档案编号
     */
    private String fileNumber;
    /**
     * @Fields  所属区域
     */
    private String belongArea;
    /**
     * @Fields  责任人
     */
    private String manager;
    /**
     * @Fields  责任人电话
     */
    private String mobile;
    /**
     * @Fields 管理单位
     */
    private String managementUnit;

    /**
     * @Fields 经度
     */
    private String longitude;
    /**
     * @Fields 纬度
     */
    private String latitude;
    /**
     * @Fields 地理位置
     */
    private String location;
    /**
     * @Fields 服务名
     */
    private String serviceName;

    /**
     * @Fields 备注信息
     */
    private String remark;


}