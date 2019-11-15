package com.aosica.message.sms.entity;

/**
 * @desc 信息类型
 */
public enum SmsType {

    /**
     * @Fields MESSAGE 短信
     */
    MESSAGE(1, "短信"),

    /**
     * @Fields WECAHT 微信公众号
     */
    WECAHT(2, "微信公众号");

    private int value = 0;

    private String label = null;

    private SmsType(int value, String label) {
        this.value = value;
        this.label = label;
    }

    /**
     * @desc 是否包含该枚举值
     * @param type
     * @return
     */
    public static boolean contain(Integer type) {
        SmsType[] types = SmsType.values();
        if (type == null) {
            return false;
        }
        for (SmsType ete : types) {
            if (ete.getValue() == type.intValue()) {
                return true;
            }
        }
        return false;
    }

    public static boolean notContain(Integer type) {
        return !contain(type);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
