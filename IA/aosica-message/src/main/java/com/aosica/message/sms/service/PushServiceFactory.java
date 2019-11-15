package com.aosica.message.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PushServiceFactory {


    private final static  String PUSH_TYPE_SMS_="sms" ;

    /**
     * 手机短信消息推送
     */
    @Autowired
    private PushService smsService ;



    public PushService get(String key) {
        if(PUSH_TYPE_SMS_.equals(key)) {
            return  smsService ;
        }
        return  null ;
    }
}
