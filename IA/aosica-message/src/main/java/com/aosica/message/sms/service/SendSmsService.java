package com.aosica.message.sms.service;

import com.aosica.common.bean.RequestResult;
import com.aosica.message.api.dto.MsgDto;
import org.springframework.web.bind.annotation.RequestParam;

public interface SendSmsService {

    RequestResult sendSms(@RequestParam(value = "msgDto") MsgDto msgDto);
}
