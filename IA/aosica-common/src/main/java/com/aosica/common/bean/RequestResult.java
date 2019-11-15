package com.aosica.common.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 *  定义请求接口的返回对象。
 */
@ApiModel(description = "设备系统类型实体类")
public class RequestResult<T> implements Serializable{

	private static final long serialVersionUID = 620798494072148127L;

	@ApiModelProperty(value = "执行成功的提示信息")
	public static final String OK_MESG="OK" ;
    /**
     * 操作成功
     */
    @ApiModelProperty(value = "执行成功的状态码")
	public static final int SUCCESS_CODE = 200 ;
    /**
     * 操作失败
     */
    @ApiModelProperty(value = "执行失败的状态码")
    public static final int FAIL_CODE = 500 ;

    /**
     * 操作失败
     */
    @ApiModelProperty(value = "执行失败的状态码")
    public static final String FAIL_MESSAGE = "执行失败" ;


    // 响应业务状态
    @ApiModelProperty(value = "执行请求返回的状态")
    private Integer status;

    // 响应消息
    @ApiModelProperty(value = "执行请求返回的信息")
    private String msg;

    // 响应中的数据
    @ApiModelProperty(value = "执行请求返回的数据")
    private T data;


    public RequestResult() {
        this(null) ;
    }


    public RequestResult(T data) {
        this.status = 200;
        this.msg = OK_MESG ;
        this.data = data;
    }


    public RequestResult(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }


    public RequestResult ok(T data) {
        return new RequestResult(data);
    }


    public static RequestResult buildOK() {
        return new RequestResult(200, OK_MESG, null);
    }


    public static RequestResult buildFail() {
        return new RequestResult(FAIL_CODE, FAIL_MESSAGE, null);
    }

    public static RequestResult buildOkData(Object data) {
        return new RequestResult(200, OK_MESG, data);
    }

    public static RequestResult build(Integer status, String msg) {
        return new RequestResult(status, msg, null);
    }

    public static RequestResult build(Integer status, String msg, Object data) {
        return new RequestResult(status, msg, data);
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "RequestResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
