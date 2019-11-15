package com.aoscia.base.dto;

import com.aosica.common.entity.BaseEntity;
import lombok.Data;

/**
 * @program: ai-planting->RoleDto
 * @description: 角色Dto
 * @author: ll
 * @create: 2019-10-31 20:37
 **/
@Data
public class RoleDto extends BaseEntity {

    private String id;//主键角色id

    private String name;//角色名称

    private String type;//角色类型:1系统管理员2.厂家人员3.运维人员4.普通用户

    private String projectId;//工程ID

/*    private String createBy;//创建人

    private Date createTime;//创建时间

    private String updateBy;//修改人

    private Date updateTime;//修改时间*/

}