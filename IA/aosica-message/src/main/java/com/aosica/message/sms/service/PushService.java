package com.aosica.message.sms.service;

import com.aosica.common.bean.RequestResult;

/**
 * 消息推送service 接口定义
 */
public interface PushService {

    /**
     * 消息推送
     */
    RequestResult send(String receiver, String templateId, String cacheKey) ;




}
