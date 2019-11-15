package com.aoscia.base.dto;

import com.aosica.common.entity.BaseEntity;
import lombok.Data;

/**
 * @program: ai-planting->MeumDto
 * @description: 菜单Dto
 * @author: ll
 * @create: 2019-10-31 19:24
 **/
@Data
public class MeunDto extends BaseEntity {


    private String id;//主键权限id

    private String name;//菜单名称

    private String url;//菜单地址

    private String parentId;//父Id

    private String type;//类型:1 web端 2App端

    private String icon;//图标

    private int sortNum;//排序

/*    private String createBy;//创建人

    private Date createTime;//创建时间

    private String updateBy;//修改人

    private Date updateTime;//修改时间*/

}
