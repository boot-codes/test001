package com.aoscia.base.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @PackgeName com.aoscia.base.dto
 * @ClassName MenuDTO.java
 * @Description: TODO
 * @Author: ylp
 * @Date: 2019/8/25 9:47
 * @UpdateUser: ylp
 * @UpdateDate: 2019/8/25$ 9:47$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@Data
@ToString
public class BuildingDto {

    /**
     * @Fields id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * @Fields  楼栋号
     */
    private String buildingNum;
    /**
     * @Fields  建筑物名
     */
    private String name;
    /**
     * @Fields  类型:1商品房(小区)2商业综合体3工业厂房4办公写字楼5楼房6集贸市场7平房8别墅9特殊类建筑10其他
     */
    private int type;
    /**
     * @Fields 安全责任人id
     */
    private String safetyDuty;

    /**
     * @Fields 安全责任人姓名
     */
    private String safetyDutyName;
    /**
     * @Fields 安全责任人电话
     */
    private String safetyDutyPhone;

    /**
     * @Fields 安全管理人id(新增时使用)
     */
    private String safetyManager;
    /**
     * @Fields 安全管理人姓名(新增时使用)
     */
    private String safetyManagerName;
    /**
     * @Fields 安全管理人电话(新增时使用)
     */
    private String safetyManagerPhone;


    /**
     * @Fields 用途:
     */
    private int purpose;
    /**
     * @Fields 所属区
     */
    private String belongArea;

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
     * @Fields 属地管辖部门
     */
    private String territorialJurisdiction;
    /**
     * @Fields 救援管辖部门
     */
    private String rescueJurisdiction;
    /**
     * @Fields 执法管理部门
     */
    private String lawEnforcementJurisdiction;
    /**
     * @Fields 地上层数
     */
    private int overgroundNum;
    /**
     * @Fields 地下层数
     */
    private int undergroundNum;
    /**
     * @Fields 服务名
     */
    private String serviceName;
    /**
     * @Fields 机构Id
     */
    private String deptId;



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
