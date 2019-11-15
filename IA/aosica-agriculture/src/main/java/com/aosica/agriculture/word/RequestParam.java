package com.aosica.agriculture.word;


import lombok.Data;

/**
 * 请求参数
 */
@Data
public class RequestParam {

    private String paramName ;

    private String value ;

    public RequestParam() {

    }

    public RequestParam(String paramName, String value) {
        this.paramName = paramName;
        this.value = value;
    }
}
