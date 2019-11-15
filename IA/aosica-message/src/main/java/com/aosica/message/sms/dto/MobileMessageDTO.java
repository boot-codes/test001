package com.aosica.message.sms.dto;

import com.aosica.message.sms.entity.AppKey;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;


public class MobileMessageDTO extends MessageDTO implements Serializable {

    private static final long serialVersionUID = -263175696794393499L;

    // 应用key
    private AppKey appKey;
    //private  Integer appKey ;

    // 通知内容
    private String notification;

    // 接收设备别名
    private String[] alias;

    // 接收用户标签
    private String[] tags;


    //默认发送开发，
    private boolean apnsProduction = true;

    //声音
    private String sound="";

    //扩展字段
    private Map<String ,String> extras;

    private  String clientIip ;


    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String[] getAlias() {
        return alias;
    }

    public void setAlias(String[] alias) {
        this.alias = alias;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public AppKey getAppKey() {
        return appKey;
    }

    public void setAppKey(AppKey appKey) {
        this.appKey = appKey;
    }

    public boolean isApnsProduction() {
        return apnsProduction;
    }

    public void setApnsProduction(boolean apnsProduction) {
        this.apnsProduction = apnsProduction;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public Map<String, String> getExtras() {
        return extras;
    }
    public void setExtras(Map<String, String> extras) {
        this.extras = extras;
    }

    public String getClientIip() {
        return clientIip;
    }

    public void setClientIip(String clientIip) {
        this.clientIip = clientIip;
    }

    @Override
    public String toString() {
        return "MobileMessageDTO{" +
            "appKey=" + appKey +
            ", notification='" + notification + '\'' +
            ", alias=" + Arrays.toString(alias) +
            ", tags=" + Arrays.toString(tags) +
            ", apnsProduction=" + apnsProduction +
            ", sound='" + sound + '\'' +
            ", extras=" + extras +
            ", clientIip='" + clientIip + '\'' +
            '}';
    }
}
