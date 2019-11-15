package com.aosica.message.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: ai-planting->MsgDto
 * @description: 短信请求传输对象
 * @author: dwj
 * @create: 2019-09-17 10:13
 **/
@Data
public class MsgDto {

    /**
     *@Fields 手机号码
     **/
    @ApiModelProperty(value = "电话号码")
    private String mobile;
    /**
     * @Fields 内容
     **/
    @ApiModelProperty(value = "信息内容")
    private String content;
    /**
     * @Fields  请求类型
     **/
    @ApiModelProperty(value = "请求类型")
    private int type;

    /**
     * @Fields  请求时间戳
     **/
    @ApiModelProperty(value = "请求时间戳")
    private  Long createTime ;
}
