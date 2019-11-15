package com.aosica.message.sms.service;

import com.aosica.message.sms.config.MessageNotificationServerConfig;
import com.aosica.message.sms.dto.MobileMessageDTO;
import com.aosica.message.sms.entity.AppKey;
import com.aosica.message.sms.entity.MesgResponse;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 极光推送的接口
 */
@Component
public class JPushService   {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(JPushService.class)  ;


    private static final String MESSAGE_PREFIX = "zdyun-" ;

    @Autowired
    private MessageNotificationServerConfig mobileConfig ;

    @Autowired
    private RestTemplate restTemplate ;

//    @Value("${spring.profiles.active}")
    private String springProfilesActive ;



    //private final  static  String MESSAGE_SERVER_URL = mobileConfig.getTarget()+mobileConfig.getPath() ;

    // APP推送信息到指定设备
    //private final static String SEND_APP_USER = MESSAGE_SERVER_URL+"/sendMobileMessageAlias.do" ;

    // APP推送信息到所有在线用户
    //private final static String SEND_APP_ALL_USER = MESSAGE_SERVER_URL+"/sendMobileMessageAll.do" ;

    // APP推送消息到指定标签组下的用户群
    //private final static String SEND_APP_USER_GROUP = MESSAGE_SERVER_URL +"/sendMobileMessageAll.do" ;



    /**
     * APP推送信息到指定设备
     */
    @Async
    public void pushMobileToUser(Map<String,String> params, String... alias)  {
        MobileMessageDTO mobileMessageDTO = null;
        try {
            mobileMessageDTO = createMobileMessageDTO(params);
            mobileMessageDTO.setAlias(getAlias(alias));
            execute(mobileMessageDTO , mobileConfig.getJpushSendToUser());
            if(params != null && params.size()>0) {
                params.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("发送信息失败");
        }
    }


    public String[] getAlias(String... value) {
        String[] alias = null ;
        if(value.length >0) {
            alias = new String[value.length];
            for (int n=0 ; n<value.length ;n++) {
                //alias[n] =MESSAGE_PREFIX+ value[n] ;
                alias[n] = springProfilesActive+"_"+value[n] ;
            }
        }
        return  alias;
    }

    /**
     * APP推送信息到所有在线用户
     */
    @Async
    public void pushMobileToAllUser(Map<String,String> params) {
        MobileMessageDTO mobileMessageDTO = null;
        try {
            mobileMessageDTO = createMobileMessageDTO(params);
            //mobileMessageDTO.setClientIip("172.16.1.198");
            execute(mobileMessageDTO , this.mobileConfig.getJpushSendToAllUser());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("发送信息失败");
        }
    }

    /**
     * APP推送消息到指定标签组下的用户群
     */
    @Async
    public void pushMobileToUserGroup(Map<String,String> extras, String message)  {
       // pushMessage(mobileMessageDTO,ResponseNullConverter.class,"sendMobileMessageTag.do");
        //execute(extras,message, SEND_APP_USER_GROUP);
    }



    /**
     * 发送请求
     */
    private MesgResponse execute(MobileMessageDTO dto , String url){
        logger.info("请求参数：" + dto);
        logger.info("url: "+ url);
        MesgResponse response = this.restTemplate.postForObject(url, dto, MesgResponse.class);
        logger.info("返回结果：" + response);
        return response;
    }


    /**
     * 创建消息对象
     * @param
     * @return
     */
    private MobileMessageDTO createMobileMessageDTO (Map<String,String> params) throws  Exception{
        MobileMessageDTO mobileMessageDTO = new MobileMessageDTO();
        //mobileMessageDTO.setAppKey(mobileConfig.getKey());
        //mobileMessageDTO.setAppKey(AppKey.PLATFORM_SANXIAO);
        mobileMessageDTO.setAppKey(AppKey.PLATFORM_ZHONGDIANYUN) ;
        if(this.mobileConfig.getApnsProduction().trim().equals("1")) {
            mobileMessageDTO.setApnsProduction(false);
        }
        else {
            mobileMessageDTO.setApnsProduction(true);
        }
        if(params.containsKey("message")) {
            mobileMessageDTO.setNotification(params.get("message"));
            params.remove("message") ;
        }
        else {
            throw  new Exception("发送的消息内容不能为空") ;
        }
        mobileMessageDTO.setSound("default");
        mobileMessageDTO.setExtras(params);
        return mobileMessageDTO;
    }


    public static String getAlias(long accountId) {
        return "" + accountId;
    }


    public static void main(String[] args) {

        JPushService jPushService = new JPushService() ;
        String[] alias = {getAlias(2886073627200L)} ;

        Map<String,String> map = new HashMap<>() ;
        map.put("message","【中电云】 发送的测试消息，点击查看详情！") ;

        jPushService.pushMobileToUser(map,alias);

    }
}
