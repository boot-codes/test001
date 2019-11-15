package com.aosica.message.sms.service.impl;

import com.aosica.common.bean.RequestResult;
import com.aosica.common.config.IdWorker;
import com.aosica.message.api.dto.MsgDto;
import com.aosica.message.sms.config.CacheUtil;
import com.aosica.message.sms.config.Constant;
import com.aosica.message.sms.config.RandomNumUtil;
import com.aosica.message.sms.entity.MessageEntity;
import com.aosica.message.sms.entity.MsgResponse;
import com.aosica.message.sms.entity.SmsType;
import com.aosica.message.sms.mapper.MessageMapper;
import com.aosica.message.sms.service.SendMsgService;
import com.aosica.message.sms.service.SendSmsService;
import com.aosica.message.sms.service.WeChatSendMsgService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: ai-planting->SendSmsServiceImpl
 * @description: 信息发送实现类
 * @author: dwj
 * @create: 2019-09-17 10:25
 **/
@Service
public class SendSmsServiceImpl implements SendSmsService {

    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private SendMsgService sendMsgService;
    @Autowired
    private WeChatSendMsgService weChatSendMsgService;
    @Override
    public RequestResult sendSms(MsgDto msgDto) {
        MsgResponse msgResponse = null;
        int type = msgDto.getType();
        String mobile = msgDto.getMobile();
        String content = msgDto.getContent();
        if(type == SmsType.MESSAGE.getValue()){
            if (StringUtils.isBlank(mobile) || mobile.length() != 11) {
             return RequestResult.build(Constant.INEXIST, "无效的手机号");
            }
            MsgDto dto = CacheUtil.get(mobile,MsgDto.class);
            if(dto != null){
                Long createTime = dto.getCreateTime();
            //如果获取验证码的时间，小于2分钟，将不再重新生成验证码，2分钟过后再生成。
            if(System.currentTimeMillis() -createTime < 2*1000*60 ) {
                return  RequestResult.build(Constant.INTIME,"请于2分钟后再重新获取验证码") ;
                }
            }
            String num = RandomNumUtil.randomCode();
             msgResponse = sendMsgService.sendMsg(mobile,num);
            //000000 短信发送成功 其余失败
            if(msgResponse.getCode().equals("000000")){
                //加入缓存
                CacheUtil.put(mobile,msgDto,2*60);
                //发送短信成功并添加纪录到数据库中
                this.saveMessage(mobile,content,type);
                return RequestResult.build(Constant.SUCCESS,"获取验证码成功，请尽快完成注册");
            }else {
                return RequestResult.build(Constant.FAIL,"获取短信失败");
            }
        }else if(type == SmsType.WECAHT.getValue()){
            //微信公众号推送
            msgResponse  = weChatSendMsgService.sendMsg("测试测试",content,"2019-09-18");
        }
        return null;
    }

    /**
     * @desc 添加纪录到消息记录表
     * @param mobile
     * @param content
     * @param type
     */
    private void saveMessage(String mobile,String content,int type){
        MessageEntity entity = new MessageEntity();
        entity.setId(IdWorker.generateId());
        if(type == SmsType.MESSAGE.getValue()){
            entity.setMobile(mobile);
        }
        entity.setType(type);
        entity.setContent(content);
        entity.setCreateTime(new Date());
        messageMapper.save(entity);
    }
}
