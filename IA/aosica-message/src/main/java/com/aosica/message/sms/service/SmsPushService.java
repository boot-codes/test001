package com.aosica.message.sms.service;

import com.aosica.common.util.IDUtils;
import com.aosica.common.bean.RequestResult;
import com.aosica.message.sms.config.MessageNotificationServerConfig;
import com.aosica.message.sms.dto.DevStatusMessageDTO;
import com.aosica.message.sms.dto.SMSMessageDTO;
import com.aosica.message.sms.entity.MesgResponse;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


/**
 * 手机短信消息推送功能实现
 */
@Component
public class SmsPushService implements PushService {


    //private  final  static  String SMS_SERVER_URL = "http://120.77.73.240:8080/messageServer/sendShortMessage.do" ;

    @Autowired
    private RestTemplate restTemplate ;

    @Autowired
    private MessageNotificationServerConfig mobileConfig ;

    //@Autowired
    //private JedisClient jedisClient ;


//    @Autowired
//    private CacheService cacheService ;




    /**
     * 消息推送
     *
     * @param receiver
     * @param templateId
     */
    @Override
    public RequestResult send(String receiver, String templateId, String cacheKey) {

        // 检测手机号是否有效.
//        if (StringUtils.isBlank(receiver) || receiver.length() != 11) {
//             return Result.build(FAIL, "无效的手机号");
//          }
//
//        PhoneCodeDTO dto= this.cacheService.getCacheObject(cacheKey + receiver, PhoneCodeDTO.class);
//        System.out.println(dto);
//        if(dto != null) {
//            Long createTime = dto.getCreateTime();
//            //如果获取验证码的时间，小于2分钟，将不再重新生成验证码，2分钟过后再生成。
//            if(System.currentTimeMillis() -createTime < 2*1000*60 ) {
//                return  Result.build(Constant.FAIL,"请于2分钟后再重新获取验证码") ;
//            }
//        }
//
//        DevStatusMessageDTO devStatusMessageDTO = createDevStatusMessageDTO(receiver);
//
//        try {
//            execute(devStatusMessageDTO, new String[] {receiver},templateId);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return Result.build(Constant.FAIL,"获取取验证码失败,请稍后重试") ;
//        }
//        dto = new PhoneCodeDTO();
//        dto.setPhoneNum(receiver).setCode(String.valueOf(devStatusMessageDTO.getCode())).setCreateTime(System.currentTimeMillis());
//        System.out.println("cacheKey:"+cacheKey + ",生成验证码：" +dto);
//        //过期时间:2*60秒=2分钟。
//        this.cacheService.setCache(cacheKey + receiver,JsonUtil.objectToJson(dto),2*60);
//
//        return Result.build(Constant.SUCCESS,"获取验证码成功，请尽快完成注册") ;
        return  null ;
    }



    /**
     * 最终执行发送请求短信请求
     * @param
     * @param
     * @return
     */
    @Async
    public MesgResponse execute(DevStatusMessageDTO val, String[] mobiles, String templateId) throws  Exception{

        SMSMessageDTO smsMessageDTO = createSMSMessageDTO(val, mobiles, templateId);
        MesgResponse result = restTemplate.postForObject(this.mobileConfig.getSmsToPhoneNumber(), smsMessageDTO, MesgResponse.class);
        System.out.println("发送短信执行结果：" +result);
        return  result ;
    }



    /**
     * 短信推送 手机验证码
     * @param val       短信内容
     * @param mobiles   号码
     */
    //@Async
    //public  void pushSMSCode(DevStatusMessageDTO val, String[] mobiles,String templateId) throws Exception {
    //
    //    //String templateId = "28";
    //    SmsResponse execute = execute(createSMSMessageDTO(val, mobiles, templateId));
    //}

    /**
     * 重置密码 手机验证码
     * @param val       短信内容
     * @param mobiles   号码
     */
    //@Async
    //public  void resetVerificationCode(DevStatusMessageDTO val, String[] mobiles) {
    //
    //    //短信模板ID SANXIAO_RESET_PASSWORD_TEMPLATE
    //    String templateId = "5";
    //    PushApi.INSTANCE.pushSms(getShortMessageDTO(val,mobiles,templateId));
    //}



    /**
     * 创建短信验证推送对象
     * @param val 内容
     * @param mobiles 手机号
     * @param templateId 模板编号
     * @return
     */
    private SMSMessageDTO createSMSMessageDTO(DevStatusMessageDTO val, String[] mobiles, String templateId){

        Map<String,Object> data = new HashedMap();
        data.put("code",val.getCode());
        SMSMessageDTO shortMessageDTO = new SMSMessageDTO() ;
        shortMessageDTO.setMobiles(mobiles);
        shortMessageDTO.setTemplateID(templateId);
        shortMessageDTO.setData(data);
        return shortMessageDTO;
    }




    /**
     * 创建推送对象
     * @return
     */
    //private MobileMessageDTO getDevStatusMessageDTO(DevStatusMessageDTO val, SMSTemplate smsTemplate){
    //    //MobileConfig config = SpringUtils.getBean(MobileConfig.class);
    //    MobileMessageDTO mobileMessageDTO = new MobileMessageDTO();
    //    Map<String,String>  extras = new HashMap<String,String>(2);
    //    mobileMessageDTO.setAppKey(this.mobileConfig.getKey());
    //    if(this.mobileConfig.getApnsProduction().equals("1")) {
    //        mobileMessageDTO.setApnsProduction(false);
    //    }
    //    else {
    //        mobileMessageDTO.setApnsProduction(true);
    //    }
    //    extras.put("alarmId",val.getAlarmId()+"");
    //    extras.put("sound",val.getSournd());
    //    if(smsTemplate.equals(REGISTERED_SUCCESS_SMS_TEMPLATE)) {
    //        mobileMessageDTO.setSound(val.getSournd());
    //        mobileMessageDTO.setNotification(val.getMessage());
    //    }else if(smsTemplate.equals(REGISTERED_FAILED_SMS_TEMPLATE)) {
    //        mobileMessageDTO.setNotification(val.getOverdueMessage());
    //    }
    //    else if(smsTemplate.equals(VERIFICATION_CODE_SMS_TEMPLATE)) {
    //        mobileMessageDTO.setNotification(val.getVerificationCode());
    //    }
    //    mobileMessageDTO.setExtras(extras);
    //    return mobileMessageDTO;
    //}



    private DevStatusMessageDTO createDevStatusMessageDTO(String phoneNum) {
        int smsCode = IDUtils.smsCode();
        DevStatusMessageDTO devStatusMessageDTO = new DevStatusMessageDTO();
        devStatusMessageDTO.setCode(Integer.valueOf(smsCode).intValue());
        //获取手机号码的最后四位
        String tel = phoneNum.substring(phoneNum.length() - 4, phoneNum.length());
        devStatusMessageDTO.setTel(Integer.parseInt(tel));
        return  devStatusMessageDTO;
    }



}
