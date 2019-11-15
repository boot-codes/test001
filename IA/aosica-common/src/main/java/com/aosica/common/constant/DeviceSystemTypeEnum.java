package com.aosica.common.constant;


/**
 * 物联网系统类型 enum
 * @PackgeName com.aosica.common.constant
 * @ClassName DeviceSystemTypeEnum.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/21 20:50
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/21$ 20:50$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public enum DeviceSystemTypeEnum {


    // 火灾自动报警系统	100
    DEVICE_SYSTEM_TYPE_HZZDBJXT("100", "火灾自动报警系统"),

    // 独立烟感云传输系统	200
    DEVICE_STATE_DLYGYCSXT("200", "独立烟感云传输系统"),

    // 粉尘监测云传输系统	300
    DEVICE_STATE_FCJCYCSXT("300", "粉尘监测云传输系统"),

    // 可燃气体云传输系统	400
    DEVICE_STATE_KRQTYCSXT("400", "可燃气体云传输系统"),

    // 电气火灾监控系统 500
    DEVICE_STATE_DQHZJKXT("500", "电气火灾监控系统"),

    // 室内水压监控系统 600
    DEVICE_STATE_SNSYJKXT("600", "室内水压监控系统"),

    // 室外水压监控系统	700
    DEVICE_STATE_SWSYJKXT("700", "室外水压监控系统"),

    // 视频监控系统	800
    DEVICE_STATE_SPJKXT("800", "视频监控系统"),

    // 应急监控云传输系统	900
    DEVICE_STATE_YJJKYCSXT("900", "应急监控云传输系统") ;


    private String key;

    private String value;

    DeviceSystemTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * @category 根据key获取对应的value值
     * @param key
     * @return
     */
    public static String getValues(String key) {
        for (DeviceSystemTypeEnum enums : DeviceSystemTypeEnum.values()) {
            if (key == enums.getKey()) {
                return enums.getValue();
            }
        }
        return null;
    }

    /**
     * @category 根据value获取对应的key值
     * @param
     * @return
     */
    public static String getkeys(String value) {
        for (DeviceSystemTypeEnum enums : DeviceSystemTypeEnum.values()) {
            if (value.equals(enums.getValue())) {
                return enums.getKey();
            }
        }
        return null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



}
