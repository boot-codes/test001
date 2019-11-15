package com.aosica.message.sms.entity;

import lombok.Data;

/**
 * @program: ai-planting->TemplateParam
 * @description: 模板消息
 * @author: dwj
 * @create: 2019-09-17 17:11
 **/
@Data
public class TemplateParam {

    /**
     * @Fields 参数名称
     */
    private String name;
    /**
     * @Fields 参数值
     */
    private String value;
    /**
     * @Fields 颜色
     */
    private String color;

    public TemplateParam(String name,String value,String color){
        this.name = name;
        this.value = value;
        this.color = color;
    }
}
