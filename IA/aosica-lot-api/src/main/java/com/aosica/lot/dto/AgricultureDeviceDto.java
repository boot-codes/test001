package com.aosica.lot.dto;

import com.aosica.common.entity.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @program: ai-planting->EquipmentDto
 * @description: 设备信息实体
 * @author: dwj
 * @create: 2019-08-21 16:40
 **/
@Data
public class AgricultureDeviceDto extends BaseEntity {
    /**
     * @Fields id
     **/
    //解决js精度丢失
    @JsonSerialize(using = ToStringSerializer.class)
    private long id;
    /**
     * @Fields 名称
     **/
    private String name;
    /**
     * @Fields 编号
     **/
    private String number;
    /**
     * @Fields 设备厂商
     **/
    private String manufacturer;
    /**
     * @Fields 出厂日期
     **/
    private String releaseDate;
    /**
     * @Fields 联网方式
     **/
    private int networkWay;
    /**
     * @Fields 接入方式
     **/
    private String accessWay;
    /**
     * @Fields 网关Id
     **/
    private String gatewayId;
    /**
     * @Fields 设备状态 (1 在线 2故障 3 离线 4报警)
     **/
    private int status;
    /**
     * @Fields 设备类型
     **/
    private int type;
    /**
     * @Fields 设备类型名
     **/
    private String typeName;
    /**
     * @Fields 设备安装位置
     **/
    private long siteId;
    /**
     * @Fields 设备安装位置
     **/
    private String site;
    /**
     * @Fields 设备安装坐标
     **/
    private String installCoordinate;
    /**
     * @Fields 设备安装详细位置
     **/
    private String installAddress;
    /**
     * @Fields 设备采集频率
     **/
    private float collectionFrequency;
    /**
     * @Fields 设备采集频率单位 月 month 天 day 小时 hour 分钟minute
     **/
    private String collectionFrequencyUnit;
    /**
     * @Fields 说明
     **/
    private String explain;
    /**
     * @Fields 设备是否在场(0 否 1是)
     **/
    private int isOnTheScene;

    /**
     * @Fields 设备是否删除(0 否 1是)
     **/
    private int isDelete;
    /**
     * @Fields 数据采集时间
     **/
    private String collectionTime;

    /**
     * @Fields 数据采集时间
     **/
    private String collectionFrequencyStr;

    /**
     * @Fields 设备创建时间
     **/
    private String updateTimeStr;

    /**
     * @Fields 异常原因
     **/
    private String statusReason;

    /**
     * @Fields 设备状态
     **/
    private String statusStr;

    /**
     * @Fields 设备状态
     **/
    private MultipartFile[] files;

    /**
     * @Fields 测量监测项
     */
    private List<AgricultureDeviceMetricalInfoDto> MetricalInfoDtoList;


}
