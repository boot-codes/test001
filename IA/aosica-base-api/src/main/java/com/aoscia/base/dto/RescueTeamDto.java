package com.aoscia.base.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @program: ai-planting->RescueTeamDto
 * @description: 救援队伍DTO
 * @author: dwj
 * @create: 2019-09-27 14:35
 **/
@Data
public class RescueTeamDto  {
    /**
     * @Fields id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * @Fields  救援队伍名称
     */
    private String name;
    /**
     * @Fields  救援队伍所属区域
     */
    private String belongArea;
    /**
     * @Fields  救援队伍所属街道
     */
    private String belongStreet;
    /**
     * @Fields  救援队伍所属社区
     */
    private String belongCommunity;
    /**
     * @Fields 单位性质(1微型消防站2社区小型消防站3街道专职消防队4武警消防中队5武警消防大队6武警消防支队)
     */
    private int unitType;
    /**
     * @Fields  标准人数
     */
    private int normNum;
    /**
     * @Fields  实际人数
     */
    private int realityNum;
    /**
     * @Fields  消防车标准数量
     */
    private int fireTruckNormNum;
    /**
     * @Fields  消防车实际数量
     */
    private int fireTruckRealityNum;
    /**
     * @Fields  责任人
     */
    private String manager;
    /**
     * @Fields  责任人电话
     */
    private String mobile;
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
