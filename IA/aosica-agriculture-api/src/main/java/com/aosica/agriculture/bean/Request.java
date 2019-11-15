package com.aosica.agriculture.bean;

import lombok.Data;

/**
 * @program: ai-planting->Request
 * @description: 请求体实体类
 * @author: dwj
 * @create: 2019-09-10 19:19
 **/
@Data
public class Request {

    /**
     * 参数名
     */
    private String name;

    /**
     * 数据类型
     */
    private String type;

    /**
     * 参数类型
     */
    private String paramType;

    /**
     * 是否必填
     */
    private Boolean require;

    /**
     * 说明
     */
    private String remark;
}
