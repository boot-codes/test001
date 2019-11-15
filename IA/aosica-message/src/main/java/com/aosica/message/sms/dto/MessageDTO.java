package com.aosica.message.sms.dto;

import java.util.Map;

/**
 *
 */
public class MessageDTO {

    private String sound ;
    /**
     *  扩展属性
     */
    private Map<String,String> extras ;
    private String  badge ;
    private String  alert ;

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

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }


    @Override
    public String toString() {
        return "MessageDTO{" +
                "sound='" + sound + '\'' +
                ", extras=" + extras +
                ", badge='" + badge + '\'' +
                ", alert='" + alert + '\'' +
                '}';
    }
}
