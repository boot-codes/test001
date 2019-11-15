package com.aoscia.base.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @program: ai-planting->SafetyBuildingManagerEntity
 * @description: 建筑物管理人员
 * @author: dwj
 * @create: 2019-09-25 20:06
 **/
@Data
@ToString
public class SafetyBuildingManagerEntity {
    /**
     * @Fields id
     */
    private Long id;
    /**
     * @Fields  楼栋号
     */
    private String buildingId;
    /**
     * @Fields  建筑物管理人员
     */
    private String safetyManager;
    /**
     * @Fields  建筑物管理人员电话
     */
    private String safetyManagerMobile;
}
