package com.aosica.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: ai-planting->BaseEntity
 * @description: 实体类基类
 * @author: dwj
 * @create: 2019-08-23 10:03
 **/
@Data
public class BaseEntity implements Serializable {
    /**
     * @Fields serialVersionUID
     */
    private static final long serialVersionUID = 620798494072148127L;

    private Date createTime;
    private long createBy;
    private Date updateTime;
    private long updateBy;
    private int pageNum= 1;//页码
    private int pageSize = 10;//条数
    private int startRow ;//每页的第一条记录的索引

}
