package com.aosica.user.entity;

import com.aosica.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @program: ai-planting->MenuEntity
 * @description: 菜单实体类
 * @author: dwj
 * @create: 2019-09-23 10:39
 **/
@Data
@ToString
@ApiModel("菜单实体类")
public class MenuEntity extends BaseEntity {
    // 一级菜单
    public static final String ONE_LEVEL_MENU = "0";

    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "菜单名")
    private String name;
    @ApiModelProperty(value = "菜单地址")
    private String url;
    @ApiModelProperty(value = "图标")
    private String icon;
    @ApiModelProperty(value = "父Id")
    private String parentId;
    @ApiModelProperty(value = "排序")
    private int sortNum;
    @ApiModelProperty(value = "1 web端 2App端")
    private int type;
    @ApiModelProperty("操作权限")
    private String operationAuthority;

}
