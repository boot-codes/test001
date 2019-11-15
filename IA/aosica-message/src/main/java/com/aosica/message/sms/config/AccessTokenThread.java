package com.aosica.message.sms.config;

import com.alibaba.fastjson.JSONObject;

/**
 * @program: ai-planting->AccessTokenThread
 * @description: 定时获取AccessToken
 * @author: dwj
 * @create: 2019-09-17 20:20
 **/
public class AccessTokenThread {

    /**
     * @desc 获取微信AccessToken并放入缓存 一小时四十五分钟更新一次
     */
    public static void getAccessToken(){
        String resultInfo = HttpClientUtil.doGet(WeiXinConfig.getAccess_token_url());
        //此时已获取到userInfo，再根据业务进行处理
        System.out.println("请求获取userInfo:" + resultInfo);
        JSONObject jsonObject = JSONObject.parseObject(resultInfo);
        System.out.println("用户access_token--------"+jsonObject.getString("access_token"));
        //把获取的access_token保存到缓存中
        CacheUtil.put("access_token",jsonObject.getString("access_token"),6300);
    }
}
