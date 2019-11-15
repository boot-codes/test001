package com.aosica.message.sms.config;

/**
 * @program: ai-planting->WeiXinConfig
 * @description: 微信配置类
 * @author: dwj
 * @create: 2019-09-17 20:14
 **/
public class WeiXinConfig {

    //微信公众号身份的唯一标识。
    public static final String APPID = "wxb3eeea34b05c3509";//appId
    //JSAPI接口中获取openid，审核后在公众平台开启开发模式后可查看
    public static final String APPSECRET = "892e7c1a5de5ddc08ca789d44386faa7";//appSecret
    //消息模板Id。
    public static final String templateId = "";//消息模板Id
    //获取ACCESS_TOKEN
    private static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

   private static String OPEN_ID_URL ="https://api.weixin.qq.com/cgi-bin/user/get?access_token=accessToken&next_openid=nextOpenId";

    public static String getAccess_token_url(){
        return ACCESS_TOKEN_URL.replace("APPID",APPID).replace("APPSECRET",APPSECRET);
    }

    public static String getOpen_id_url(String accessToken, String nextOpenId){
        return OPEN_ID_URL.replace("accessToken",accessToken).replace("nextOpenId",nextOpenId);
    }
    //模板消息路径
    public static String templateMsgUrl= "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
}
