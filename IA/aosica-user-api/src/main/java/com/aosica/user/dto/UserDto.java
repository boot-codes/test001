package com.aosica.user.dto;

import com.aosica.common.entity.BaseEntity;

/**
 * @PackgeName com.aoscia.base.dto
 * @ClassName UserDTO.java
 * @Description: TODO
 * @Author: ylp
 * @Date: 2019/8/25 9:47
 * @UpdateUser: ylp
 * @UpdateDate: 2019/8/25$ 9:47$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

public class UserDto extends BaseEntity {

    private Long id ;
    private String name ;
    private String account ;
    private String password ;
    private String salt ;
    private String mobile ;
    private String email ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
