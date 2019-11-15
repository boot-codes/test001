package com.aosica.user.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserLoginDTO {

    /**
     * 用户登录账号
     */
    @NotNull
    private String account  ;


    /**
     * 用户密码
     */
    @NotNull
    private String password ;

}
