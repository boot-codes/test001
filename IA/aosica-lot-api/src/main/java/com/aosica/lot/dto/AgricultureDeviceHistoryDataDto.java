package com.aosica.lot.dto;

import lombok.Data;

/**
 * @program: ai-planting->EquipmentHistoryDataDto
 * @description:设备历史数据实体类
 * @author: dwj
 * @create: 2019-08-23 10:21
 **/
@Data
public class AgricultureDeviceHistoryDataDto {
    /**
     * @Fields 数据上传时间
     **/
    private String collectionTime;
    /**
     * @Fields 数据类型
     **/
    private String warnName;

    /**
     * @Fields 数据值
     **/
    private double value;
    /**
     * @Fields 正常范围最小值
     **/
    private String normalValue;

}
