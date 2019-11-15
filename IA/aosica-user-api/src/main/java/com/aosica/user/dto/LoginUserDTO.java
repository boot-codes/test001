package com.aosica.user.dto;


import lombok.Data;

/**
 * 用户登录后返回的用户信息DTO
 */
@Data
public class LoginUserDTO {

    /**
     * 用户id
     */
    private Long userId ;

    /**
     * 用户token
     */
    private String token ;

    /**
     *  登录账号
     */
    private String account ;




}
