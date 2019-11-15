package com.aosica.message.sms.entity;

import lombok.Data;

/**
 * @program: ai-planting->MsgResponse
 * @description: 返回对象
 * @author: dwj
 * @create: 2019-09-17 15:37
 **/
@Data
public class MsgResponse {

    /**
     * 状态码
     */
    private  String code ;

    /**
     * 返回消息
     */
    private  String description ;

    /**
     * 返回结果
     */
    private  String result ;
}
