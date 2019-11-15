package com.aosica.message.sms.config;

import com.aosica.message.sms.entity.AppKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;

@Singleton
@Component
@Configuration
public class MessageNotificationServerConfig {

//    @Value("${message.server.url}")
    private String target;

//    @Value("${message.server.context}")
    private String path;

//    @Value("${mobile.key}")
    private Integer key;

//    @Value("${mobile.apnsProduction}")
    private String apnsProduction;


    // APP推送信息到指定设备
//    @Value("${mesg.jpush.send.to.user}")
    private String jpushSendToUser ;

    // APP推送信息到所有在线用户
//    @Value("${mesg.jpush.send.to.all.user}")
    private String jpushSendToAllUser ;

    //APP推送消息到指定标签组下的用户群
//    @Value("${mesg.jpush.send.group}")
    private String jpushSendGroup ;


    // 推送到手机号。
//    @Value("${mesg.sms.to.phone.number}")
    private String smsToPhoneNumber  ;



    public String getTarget() {
        return target;
    }


    public String getPath() {
        return path;
    }


    public String getApnsProduction() {
        return apnsProduction;
    }

    public String getJpushSendToUser() {
        return jpushSendToUser;
    }

    public String getJpushSendToAllUser() {
        return jpushSendToAllUser;
    }

    public String getJpushSendGroup() {
        return jpushSendGroup;
    }

    public String getSmsToPhoneNumber() {
        return smsToPhoneNumber;
    }

    public AppKey getKey() {
        switch (key){
            case 3:
                return AppKey.PLATFORM_LONGHUA;
            case 2:
                return AppKey.PLATFORM_SANXIAO;
            case 1:
                return AppKey.PLATFORM_SUPERVISE;
            case 12:
                return AppKey.PLATFORM_ZHONGDIANYUN;
        }
        return null;
    }
}