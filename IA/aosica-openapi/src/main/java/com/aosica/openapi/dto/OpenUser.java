package com.aosica.openapi.dto;


import lombok.Data;

@Data
public class OpenUser {

    /**
     * user id
     */
    private String userId ;


    /**
     *  user secret
     */
    private String secret ;

    /**
     * 创建时间
     */
    private long createTime ;


}
