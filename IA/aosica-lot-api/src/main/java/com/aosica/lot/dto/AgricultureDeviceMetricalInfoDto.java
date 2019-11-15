package com.aosica.lot.dto;

import com.aosica.common.entity.BaseEntity;
import lombok.Data;

/**
 * @program: ai-planting->EquipmentMetricalInfoDto
 * @description: 设备测量信息
 * @author: dwj
 * @create: 2019-08-23 10:11
 **/
@Data
public class AgricultureDeviceMetricalInfoDto extends BaseEntity {

    /**
     * @Fields id
     **/
    private long id;
    /**
     * @Fields 设备Id
     **/
    private String equipmentId;
    /**
     * @Fields 测量值名称
     **/
    private String name;
    /**
     * @Fields 测量值单位
     **/
    private String unit;
    /**
     * @Fields 测量范围
     **/
    private String measurementRange;
    /**
     * @Fields 测量原理
     **/
    private String theory;
    /**
     * @Fields 测量精度
     **/
    private String measurementPrecision;
    /**
     * @Fields 预警类型(关联字典表)
     **/
    private int warningType;

    /**
     * @Fields 预警类型名
     **/
    private String warningTypeName;
    /**
     * @Fields 预警值范围最小值
     **/
    private double warningValueMin;
    /**
     * @Fields 预警值范围最大值
     **/
    private double warningValueMax;
    /**
     * @Fields 正常范围最小值
     **/
    private double normalValueMin;
    /**
     * @Fields 正常范围最大值
     **/
    private double normalValueMax;

}
