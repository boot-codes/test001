package com.aosica.message.sms.entity;

/**
 * app枚举
 * @author Administrator
 *
 */
public enum AppKey {

    PLATFORM_SUPERVISE(1), // 执法平台监管APP
    PLATFORM_SANXIAO(2),// 三小
    PLATFORM_LONGHUA(3),  //龙华
    PLATFORM_YINHUAN(4),  //隐患闭合系统
    PLATFORM_WUHAI(5),  //乌海系统
    PLATFORM_JINGLE(6),  //景乐系统
    PLATFORM_LIGUANG(7),  //黎光系统
    PLATFORM_BAOAN(8), //宝安三小系统
    PLATFORM_ZHONGDIANYUN(12);  //宝安三小系统

    private Integer appCode;

    private AppKey(Integer appCode) {
        this.appCode = appCode;
    }

    public static  AppKey getAppKey(Integer appCode) {

        switch (appCode) {
            case 1:
                return AppKey.PLATFORM_SUPERVISE;
            case 2:
                return AppKey.PLATFORM_SANXIAO;
            case 3:
                return AppKey.PLATFORM_LONGHUA;
            case 4:
                return AppKey.PLATFORM_YINHUAN;
            case 5:
                return AppKey.PLATFORM_WUHAI;
            case 6:
                return AppKey.PLATFORM_JINGLE;
            case 7:
                return AppKey.PLATFORM_LIGUANG;
            case 8:
                return AppKey.PLATFORM_BAOAN;
            case 12:
                return AppKey.PLATFORM_ZHONGDIANYUN;

            default:
                return null;
        }
    }

    

}