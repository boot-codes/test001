package com.aosica.user.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @program: ai-planting->BuildingManageDto
 * @description: 消防管理信息Dto
 * @author: ll
 * @create: 2019-11-06 17:48
 **/


@Data
@ToString
public class BuildingResponsiblePersonDto {

    private Long id;   //id

    private String realName;  //姓名

    private int type;  //类型:1,安全管理人,2,安全责任人

    private String phone; //联系电话

    private String idcardNo; //身份证号

    private String safetyQualificationCertificate; //安全资格证图片路径BuildingManageController

   // private String buildingId;//建筑物id

}
