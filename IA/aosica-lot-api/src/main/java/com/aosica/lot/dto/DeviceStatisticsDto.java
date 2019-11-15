package com.aosica.lot.dto;


import com.aosica.common.annotation.SpecialCharacterCheck;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/** 设备统计DTO
 * @PackgeName com.aosica.lot.dto
 * @ClassName DeviceStatisticsDto.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/26 20:18
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/26$ 20:18$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@Data
@ApiModel(description = "消防设备统计DTO")
public class DeviceStatisticsDto {


    @ApiModelProperty(value = "分页页数",required = true)
    private int pageNum =0 ;

    @ApiModelProperty(value = "每页显示的条数",notes = "默认每页显示10条",required = true)
    private int pageSize=10 ;

    /**
     * 查询类型
     *  1= 建筑物视觉
     *  2= 设备视觉
     *
     */

    @NotNull(message = "查询类型不能为空")
    @ApiModelProperty(value = "查询类型",name = "queryType",dataType = "int",example = "1:建筑物视觉，2:设备视觉")
    private int queryType =1 ;

    /**
     * 工程 id
     */
    @NotNull(message = "工程id 不能为空")
    @ApiModelProperty(value = "工程id",name = "projectId",dataType = "String",required = true)
    private String projectId ;


    @SpecialCharacterCheck
    @ApiModelProperty(value = "建筑物名称")
    private String buildingName ;

}
