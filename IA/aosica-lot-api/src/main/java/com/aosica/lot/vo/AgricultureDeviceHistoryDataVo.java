package com.aosica.lot.vo;

import com.aosica.lot.dto.AgricultureDeviceHistoryDataDto;
import lombok.Data;

import java.util.List;

/**
 * @program: ai-planting->EquipmentHistoryDataVo
 * @description: 设备历史数据展示
 * @author: dwj
 * @create: 2019-08-28 09:58
 **/
@Data
public class AgricultureDeviceHistoryDataVo {
    /**
     * @Fields 记录总数
     **/
    private Integer recordTotal;
    /**
     * @Fields 记录总数
     **/
    private List<AgricultureDeviceHistoryDataDto> list;
}
