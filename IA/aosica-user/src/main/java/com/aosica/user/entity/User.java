package com.aosica.user.entity;

import lombok.Data;

import java.util.Date;


@Data
public class User {
    /**
     * 用户 id id
     */
    private Long id;

    /**
     * 用户登录账号 account
     */
    private String account;

    /**
     * 盐 salt
     */
    private String salt;

    /**
     * 密码 password
     */
    private String password;

    /**
     * 用户真实姓名 realName
     */
    private String realName;

    /**
     * 手机号 phone
     */
    private String phone;

    /**
     * 邮箱 email
     */
    private String email;

    /**
     * 工程id project_id
     */
    private String projectId;

    /**
     * 角色id user_role_id
     */
    private Long userRoleId;

    /**
     * 用户角度名称 user_role_name
     */
    private String userRoleName;

    /**
     * 创建时间 create_time
     */
    private Date createTime;

    /**
     * 最后登录时间 last_login_time
     */
    private Date lastLoginTime;

    /**
     * 登录 ip login_ip
     */
    private String loginIp;

    /**
     * 用户状态 status
     */
    private Integer status;


}