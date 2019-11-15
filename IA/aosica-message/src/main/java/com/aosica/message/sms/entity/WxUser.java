package com.aosica.message.sms.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: ai-planting->WxUser
 * @description: 微信openId
 * @author: dwj
 * @create: 2019-09-18 14:07
 **/
@Data
public class WxUser implements Serializable {
    private static final long serialVersionUID = 1389073042674901032L;
    /**
     * @Fields 关注该公众账号的总用户数
     */
    private int total;
    /**
     * @Fields 拉取的OPENID个数，最大值为10000
     */
    private int count;
    /**
     * @Fields 列表数据，OPENID的列表
     */
    private List<String> data;
    /**
     * @Fileds 拉取列表的最后一个用户的OPENID
     */
    private String next_openid;

}
