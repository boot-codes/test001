package com.aosica.message.sms.entity;

import lombok.Data;

/**
 * @program: ai-planting->AccessToken
 * @description: 微信Token
 * @author: dwj
 * @create: 2019-09-17 20:12
 **/
@Data
public class AccessToken {
    /**
     * @Fields access_toekn 凭证
     */
    private String access_token;
    /**
     * @Fields 有效时间
     */
    private int expires_in;

    public AccessToken(String access_token, int expires_in) {
        this.access_token = access_token; this.expires_in = expires_in;
    }
}
