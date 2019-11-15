package com.aoscia.base.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @program: ai-planting->BuildingImportantPart
 * @description: 建筑物重点部位
 * @author: ll
 * @create: 2019-11-06 16:37
 **/


@Data
@ToString
public class BuildingImportantPartEntity {

    private Long id;//id

    private String pictureUrl;//图片url

    private String pictureDescribe; //图片描述

    private String buildingId;//建筑物id

    private int foor;//层数

    private String location;//具体地址

    private int fireExtinguisherType;//灭火器类型

}