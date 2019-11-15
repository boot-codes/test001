package com.aosica.message.api.api;

import com.aosica.common.bean.RequestResult;
import com.aosica.message.api.dto.MsgDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("sendMessage")
public interface SendMessageServiceApi {

    /**
     * @description 发送信息通知
     * @param msgDto
     */
    @ApiOperation(value = "发送信息通知",notes = "")
    @ApiImplicitParam(dataTypeClass = MsgDto.class)
    @PostMapping("sendSms")
    RequestResult sendSms(MsgDto msgDto);
}
