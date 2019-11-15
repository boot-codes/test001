package com.aoscia.base.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @program: ai-planting->FireHydrantDto
 * @description: 室外消防栓
 * @author: dwj
 * @create: 2019-09-27 16:44
 **/
@Data
public class FireHydrantDto  {

    /**
     * @Fields id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * @Fields  消防栓编号
     */
    private String number;
    /**
     * @Fields  消防栓所属区域
     */
    private String belongArea;
    /**
     * @Fields  消防栓所属街道
     */
    private String belongStreet;
    /**
     * @Fields  消防栓所属社区
     */
    private String belongCommunity;
    /**
     * @Fields 单位性质(1市政2工业3物业小区)
     */
    private int unitType;
    /**
     * @Fields  启用日期
     */
    private String startDate;
    /**
     * @Fields  供水水压
     */
    private String waterGage;
    /**
     * @Fields  运行情况
     */
    private String runingCondition;

    /**
     * @Fields  责任人
     */
    private String manager;
    /**
     * @Fields  责任人电话
     */
    private String mobile;
    /**
     * @Fields  监管单位
     */
    private String monitoringUnit;
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
}
