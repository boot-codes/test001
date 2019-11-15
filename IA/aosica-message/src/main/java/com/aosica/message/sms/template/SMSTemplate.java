package com.aosica.message.sms.template;

/**
 * 短信模板枚举
 * 
 * @author Administrator
 *
 */
public enum SMSTemplate {

    /**
     * 注册账号审核通过通知短信
     */
    REGISTERED_SUCCESS_SMS_TEMPLATE(1641262, new SuccusssTemplate()),
    /**
     * 注册审核未通过通知短信
     */
    REGISTERED_FAILED_SMS_TEMPLATE(1645758, new SuccusssTemplate()),
    /**
     * 短信验证码模板
     */
    VERIFICATION_CODE_SMS_TEMPLATE(1780126, new CheckCodeTemplate()),

    /** 重置密码短信验证模板*/
    SANXIAO_RESET_PASSWORD_TEMPLATE(1828348, new CheckCodeTemplate());
    
    private long code;

    private ShortMessageTemplate template;

    private SMSTemplate(long code, ShortMessageTemplate template) {
        this.setCode(code);
        this.setTemplate(template);
    }

    public ShortMessageTemplate getTemplate() {
        return template;
    }

    public void setTemplate(ShortMessageTemplate template) {
        this.template = template;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

}