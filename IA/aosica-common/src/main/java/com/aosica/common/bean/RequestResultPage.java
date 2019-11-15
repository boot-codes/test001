package com.aosica.common.bean;

import com.github.pagehelper.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *  定义请求接口的，返回对象。
 */
@Data
@ApiModel(description = "具有分页信息的接口调用结果返回对象")
public class RequestResultPage<T> implements Serializable {

	private static final long serialVersionUID = 620798494072148127L;

    // 响应业务状态
    @ApiModelProperty(value = "请求的响应状态")
    private Integer status;

    // 响应消息
    @ApiModelProperty(value = "响应消息")
    private String msg;

    // 响应中的数据
    @ApiModelProperty(value = "请求响应的数据")
    private Page data;


    /**
     * 当前页数，从1开始
     */
    @ApiModelProperty(value = "当前页数")
    private int pageNum;
    /**
     * 每页显示的记录数
     */
    @ApiModelProperty(value = "每页显示的记录数")
    private int pageSize;
    /**
     * 起始行
     */
    @ApiModelProperty(value = "起始行")
    private int startRow;
    /**
     * 末行
     */
    @ApiModelProperty(value = "结束行")
    private int endRow;
    /**
     * 总数
     */
    @ApiModelProperty(value = "总数")
    private long total;
    /**
     * 总页数
     */
    @ApiModelProperty(value = "总页数")
    private int pages;


    public RequestResultPage() {

    }

    public static RequestResultPage buildOK() {
        return new RequestResultPage(null);
    }

    public static RequestResultPage buildOK(Page data) {
        return new RequestResultPage(data);
    }

    public static RequestResultPage buildFail() {
        return new RequestResultPage(-1, "请求失败", null);
    }

    public static RequestResultPage buildFail(String failMessage) {
        return new RequestResultPage(-1, failMessage, null);
    }

    public static RequestResultPage build(Integer status, String msg, Page data) {
        return new RequestResultPage(status, msg, data);
    }


    public static RequestResultPage build(Integer status, String msg) {
        return new RequestResultPage(status, msg, null);
    }

    public RequestResultPage(Integer status, String msg, Page data) {
        this.status = status ;
        this.msg = msg ;
        this.data = data ;
        /*** 当前页数，从1开始*/
        this.pageNum = data.getPageNum();
        /*** 每页显示的记录数*/
        this.pageSize = data.getPageSize();
        /*** 起始行*/
        this.startRow = data.getStartRow();
        /*** 末行*/
        this.endRow = data.getEndRow();
        /*** 总数*/
        this.total = data.getTotal();
        /*** 总页数*/
        this.pages = data.getPages();
    }

    public RequestResultPage(Page data) {
        this.status = 1;
        this.msg = "OK";
        this.data = data;
        /*** 当前页数，从1开始*/
        this.pageNum = data.getPageNum();
        /*** 每页显示的记录数*/
        this.pageSize = data.getPageSize();
        /*** 起始行*/
        this.startRow = data.getStartRow();
        /*** 末行*/
        this.endRow = data.getEndRow();
        /*** 总数*/
        this.total = data.getTotal();
        /*** 总页数*/
        this.pages = data.getPages();
    }


}
