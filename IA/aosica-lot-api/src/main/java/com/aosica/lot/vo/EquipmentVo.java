package com.aosica.lot.vo;

import com.aosica.lot.dto.EquipmentDto;
import lombok.Data;

import java.util.List;

/**
 * @program: ai-planting->EquipmentVo
 * @description: 设备展示对象
 * @author: dwj
 * @create: 2019-09-11 14:32
 **/
@Data
public class EquipmentVo {
    /**
     * @Fields 记录总数
     **/
    private Integer recordTotal;
    /**
     * @Fields 记录总数
     **/
    private List<EquipmentDto> list;
}
