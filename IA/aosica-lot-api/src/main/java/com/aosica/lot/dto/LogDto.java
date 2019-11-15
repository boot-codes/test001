package com.aosica.lot.dto;

import com.aosica.common.entity.BaseEntity;
import lombok.Data;

/**
 * @program: ai-planting->LogDto
 * @description: 日志类
 * @author: dwj
 * @create: 2019-08-30 11:04
 **/
@Data
public class LogDto extends BaseEntity {
    /**
     * @Fields id
     **/
    private long id;
    /**
     * @Fields 操作类型(1 新增 2 修改 3删除 4 查看 5 设备消音 6设备报警处理 7故障处理 8离线处理)
     **/
    private int type;
    /**
     * @Fields 业务Id
     **/
    private String billId;
    /**
     * @Fields 操作结果
     **/
    private String result;

    /**
     * @Fields 说明
     **/
    private String explain;
    /**
     * @Fields 操作人
     **/
    private String operationBy;

    /**
     * @Fields 设备编号
     **/
    private String number;

    /**
     * @Fields 设备名称
     **/
    private String name;

    /**
     * @Fields 设备安装位置
     **/
    private String installAddress;
    /**
     * @Fields 设备安装位置
     **/
    private String operTime;

}
