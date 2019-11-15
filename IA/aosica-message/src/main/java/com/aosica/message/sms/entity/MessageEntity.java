package com.aosica.message.sms.entity;

import com.aosica.common.entity.BaseEntity;
import lombok.Data;

/**
 * @program: ai-planting->MessageEntity
 * @description: 消息实体类
 * @author: dwj
 * @create: 2019-09-17 12:00
 **/
@Data
public class MessageEntity extends BaseEntity {

    /**
     * @Fields id
     */
    private long id;
    /**
     * @Fields 类型 1短信 2 微信
     */
    private int type;
    /**
     * @Fields 电话
     */
    private String mobile;
    /**
     * @Fields 微信号
     */
    private String wechatName;
    /**
     * @Fields 内容
     */
    private String content;
}
