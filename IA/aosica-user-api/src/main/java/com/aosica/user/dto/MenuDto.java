package com.aosica.user.dto;

import com.aosica.common.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

import java.util.List;

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
public class MenuDto extends BaseEntity {

    /**
     * @Fields id
     */
    private String id;
    /**
     * @Fields name 菜单名
     */
    private String name;
    /**
     * @Fields url 菜单地址
     */
    private String url;
    /**
     * @Fields icon 菜单图标
     */
    private String icon;
    /**
     * @Fields parentId 父菜单Id
     */
    private String parentId;
    /**
     * @Fields sortNum 菜单顺序
     */
    private int sortNum;
    /**
     * @Fields type 1 web端 2App端
     */
    private int type;
    /**
     * @Fields 操作权限
     */
    private String operationAuthority;
    /**子菜单**/
    private List<MenuDto> childMenus;
}
