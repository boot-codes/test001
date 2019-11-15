package com.aoscia.base.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @program: ai-planting->BuildingSecurityMassageDto
 * @description: 建筑物消防安全信息Dto
 * @author: ll
 * @create: 2019-11-06 17:50
 **/
@Data
@ToString
public class BuildingSecurityMassageDto {

    private Long id;   //id,即建筑物id

    private int fireControlRoom;  //消防控制室:1,有,0,无

    private int safeExit;  //安全出口个数

    private int evacuationStaircase;  //疏散楼梯个数

    private int fireLane;  //消防车道条数

    private String otherFacilities;  //其他设施(字符串表示,设施名称之间以逗号隔开)

    private List fireFacilitiesList;  //消防设施

   // private List<String> otherFacilitiesList;  //其他设施

    private List<BuildingImportantPartEntity> buildingImportantPartEntitys; //重点部位

}
