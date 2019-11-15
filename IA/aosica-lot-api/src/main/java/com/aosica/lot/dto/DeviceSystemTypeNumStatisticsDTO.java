package com.aosica.lot.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 *  按项目工程统计，统计某个工程下，设备系统的数据，设备的总数量，不正常的设备数量
 * @PackgeName com.aosica.lot.dto
 * @ClassName DeviceSystemTypeNumStatisticsDTO.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/23 14:59
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/23$ 14:59$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@Data
@ApiModel(description = "按项目工程统计，统计某个工程下，设备系统的数据，设备的总数量，不正常的设备数量")
public class DeviceSystemTypeNumStatisticsDTO implements Serializable {


    private static final long serialVersionUID = -6917468294045462400L;

    /**
     * 建筑物名称
     */
    @ApiModelProperty(value = "建筑物名称")
    private String buildingName ;

    /**
     *  系统类型
     */
    @ApiModelProperty(value = "系统类型")
    private String systemType ;

    /**
     * 系统数量
     */
    @ApiModelProperty(value = "系统数量")
    private int systemTypeNum ;


    /**
     * 设备总数
     */
    @ApiModelProperty(value = "设备总数")
    private int deviceNum ;


    /**
     * 正常设备数据
     */
    @ApiModelProperty(value = "正常设备数据")
    private int normalDeviceNum ;

    /**
     * 异常设备数量
     */
    @ApiModelProperty(value = "exceptionDeviceNum")
    private int exceptionDeviceNum ;
}
