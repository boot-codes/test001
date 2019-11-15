package com.aosica.user.dto;


import com.aosica.common.annotation.SpecialCharacterCheck;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 *  创建用户的 dto
 */
@Data
public class UserInfoDto {

    /**
     * 用户登录账号 account
     */
    @NotNull(message = "account 不能为空")
    private String account;

    /**
     * 密码 password
     */
    @SpecialCharacterCheck
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
    @NotNull(message = " 工程 id 不能为空")
    private String projectId;

    /**
     * 角色id user_role_id
     */
    private Long userRoleId;

    /**
     * 用户角度名称 user_role_name
     */
    private String userRoleName;



}
