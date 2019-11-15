package com.aosica.openapi.entity;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *  开放平台用户角色实体类
 */

@ApiModel(description = "开放平台用户角色实体类")
@Data
public class OpenUserRole implements Serializable{

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id",required = true)
    private Long roleId;

    /**
     *  角色名称
     */
    @ApiModelProperty(value = "角色名称",required = true)
    private String roleName;

    /**
     * 角色描述
     */
    @ApiModelProperty(value = "角色名称")
    private String roleDesc;

    /**
     * 角色类类型
     *
     */
    @ApiModelProperty(value = "角色类类型")
    private Integer roleType;

    /**
     *
     */
    @ApiModelProperty(value = "角色编码")
    private String roleCode;

    /**
     *
     */
    @ApiModelProperty(value = "创建人")
    private Long createBy;

    /**
     *
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     *
     */
    @ApiModelProperty(value = "更新人")
    private Long updateBy;

    /**
     *
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}