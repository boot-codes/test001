package com.aoscia.base.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @program: ai-planting->FightingWaterDto
 * @description: 消防水源dto
 * @author: dwj
 * @create: 2019-09-26 14:39
 **/
@Data
public class FightingWaterDto
        //extends BaseEntity
{
    /**
     * @Fields id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * @Fields 1河流 2湖泊 3人工湖 4消防水池
     */
    private int type;
    /**
     * @Fields  编号
     */
    private String number;

    /**
     * @Fields  水位
     */
    private String waterLevel;
    /**
     * @Fields  储水量
     */
    private String waterCapacity;
    /**
     * @Fields  档案编号
     */
    private String fileNumber;
    /**
     * @Fields  所属区域
     */
    private String belongArea;
    /**
     * @Fields  责任人
     */
    private String manager;
    /**
     * @Fields  责任人电话
     */
    private String mobile;
    /**
     * @Fields 管理单位
     */
    private String managementUnit;

    /**
     * @Fields 经度
     */
    private String longitude;
    /**
     * @Fields 纬度
     */
    private String latitude;
    /**
     * @Fields 地理位置
     */
    private String location;
    /**
     * @Fields 服务名
     */
    private String serviceName;
    /**
     * @Fields 项目id
     */
    private String projectId;


    @Override
    public String toString() {
        return "FightingWaterDto{" +
                "id=" + id +
                ", type=" + type +
                ", number='" + number + '\'' +
                ", waterLevel='" + waterLevel + '\'' +
                ", waterCapacity='" + waterCapacity + '\'' +
                ", fileNumber='" + fileNumber + '\'' +
                ", belongArea='" + belongArea + '\'' +
                ", manager='" + manager + '\'' +
                ", mobile='" + mobile + '\'' +
                ", managementUnit='" + managementUnit + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", location='" + location + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", projectId='" + projectId + '\'' +
                "} " + super.toString();
    }
}
