package com.aosica.agriculture.vo;

import com.aosica.agriculture.bean.Request;
import com.aosica.agriculture.bean.Response;
import lombok.Data;

import java.util.List;

/**
 * @program: ai-planting->Table
 * @description:
 * @author: dwj
 * @create: 2019-09-10 19:14
 **/
@Data
public class Table {
    /**
     * 大标题
     */
    private String title;
    /**
     * 小标题
     */
    private String tag;
    /**
     * url
     */
    private String url;

    /**
     * 描述
     */
    private String description;

    /**
     * 请求参数格式
     */
    private String requestForm;

    /**
     * 响应参数格式
     */
    private String responseForm;

    /**
     * 请求方式
     */
    private String requestType;

    /**
     * 请求体
     */
    private List<Request> requestList;

    /**
     * 返回体
     */
    private List<Response> responseList;

    /**
     * 请求参数
     */
    private String requestParam;

    /**
     * 返回参数
     */
    private String responseParam;
}
