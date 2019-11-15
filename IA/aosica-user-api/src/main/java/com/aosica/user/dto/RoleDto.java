package com.aosica.user.dto;

import com.aosica.common.entity.BaseEntity;

/**
 * @PackgeName com.aoscia.base.dto
 * @ClassName RoleDTO.java
 * @Description: TODO
 * @Author: ylp
 * @Date: 2019/8/25 9:47
 * @UpdateUser: ylp
 * @UpdateDate: 2019/8/25$ 9:47$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public class RoleDto extends BaseEntity {

    private Long id ;
    private String roleName ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
