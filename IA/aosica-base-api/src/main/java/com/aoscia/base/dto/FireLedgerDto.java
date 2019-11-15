package com.aoscia.base.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @program: ai-planting->fireLedgerDto
 * @description: 消防台账Dto
 * @author: ll
 * @create: 2019-11-02 19:21
 **/

@Data
@ToString
public class FireLedgerDto {

    /**
     * @Fields id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * @Fields 室外消防栓编号
     */
    private String number;


    /**
     * @Fields 台账类型(1消防设备2应急物资)
     */
    private int type;

    /**
     * @Fields 品牌
     */
    private String brand;

    /**
     * @Fields 型号
     */
    private String model;

    /**
     * @Fields 生产日期
     */
    private String dateManufacture;

    /**
     * @Fields 有效日期
     */
    private String dateEffective;

    /**
     * @Fields 机构Id
     */
    private String deptId;

    /**
     * @Fields 建筑物Id
     */
    private String buildingId;

    /**
     * @Fields 楼层
     */
    private String floor;

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
     * @Fields 服务名称
     */
    private String serviceName;


    /**
     * @Fields 备注
     */
    private String remark;

    //公共属性
    @ApiModelProperty(value = "分页页数", required = true)
    private int pageNum = 0;

    @ApiModelProperty(value = "每页显示的条数", required = true)
    private int pageSize = 10;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;


    @NotNull
    @ApiModelProperty(value = "工程id", required = true)
    private String projectId;
}