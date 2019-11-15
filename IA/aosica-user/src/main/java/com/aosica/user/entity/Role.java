package com.aosica.user.entity;

/**
 * @PackgeName com.aoscia.base.entity
 * @ClassName Role.java
 * @Description: TODO
 * @Author: ylp
 * @Date: 2019/8/25 9:56
 * @UpdateUser: ylp
 * @UpdateDate: 2019/8/25$ 9:56$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */


import lombok.Data;
import lombok.ToString;

/**
 * 功能描述: Role 对应数据库表里的ai_role表实体类.
 *
 * @param:
 * @return:
 * @auther: ylp
 * @date: 2019/8/25 9:57
 */

@Data
@ToString
public class Role {


    private Long id;

    private String roleName;

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
