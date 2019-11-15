package com.aosica.fscp.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @PackgeName com.aosica.lot.api.dto
 * @ClassName DeviceStatueDto.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/10/8 11:50
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/10/8$ 11:50$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@Data
@ApiModel(value = "物联监控设备数据统计")
public class DeviceStatueDto {

    /**
     * 设备状态
     * 1:正常，2:失联，3:告警，4:故障
     */
    @ApiModelProperty(value = "设备状态",notes = "1:正常，2:失联，3:告警，4:故障")
    private int deviceStatue ;

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private int num ;


    /**
     *  占比
     */
    @ApiModelProperty(value = "占比(%)")
    private String percentage ;


}
