package com.aosica.message.sms.dto;

import java.io.Serializable;
import java.util.Map;

public class SMSMessageDTO extends MessageDTO implements Serializable {
    private static final long serialVersionUID = 3327168849733931801L;

    /**
     * 短信模板
     */
    private String templateID;

    /**
     * 短信属性内容
     */
    private Map<String,Object> data;

    /**
     * 接收短信手机号
     */
    private String[] mobiles;

    public String getTemplateID() {
        return templateID;
    }

    public void setTemplateID(String templateID) {
        this.templateID = templateID;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String[] getMobiles() {
        return mobiles;
    }

    public void setMobiles(String[] mobiles) {
        this.mobiles = mobiles;
    }
}
