package com.aosica.message.sms.api;

import com.aosica.common.bean.RequestResult;
import com.aosica.message.api.api.SendMessageServiceApi;
import com.aosica.message.api.dto.MsgDto;
import com.aosica.message.sms.service.SendSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ai-planting->SendSmsApiService
 * @description: 信息对外服务
 * @author: dwj
 * @create: 2019-09-17 11:34
 **/
@RestController
public class SendSmsApiService implements SendMessageServiceApi {

    @Autowired
    private SendSmsService sendSmsService;

    @Override
    public RequestResult sendSms(MsgDto msgDto) {
        RequestResult requestResult =   sendSmsService.sendSms(msgDto);
        return requestResult;
    }
}
