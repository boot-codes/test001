package com.aosica.agriculture.bean;

import lombok.Data;

/**
 * @program: ai-planting->Response
 * @description: 返回实体类
 * @author: dwj
 * @create: 2019-09-10 19:20
 **/
@Data
public class Response {

    /**
     * 返回参数
     */
    private String description;

    /**
     * 参数名
     */
    private String name;

    /**
     * 备注
     */
    private String remark;
}
