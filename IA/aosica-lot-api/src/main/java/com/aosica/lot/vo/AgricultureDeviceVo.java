package com.aosica.lot.vo;

import com.aosica.lot.dto.AgricultureDeviceDto;
import lombok.Data;

import java.util.List;

/**
 * @program: ai-planting->EquipmentVo
 * @description: 设备列表展示对象
 * @author: dwj
 * @create: 2019-08-28 09:33
 **/
@Data
public class AgricultureDeviceVo {

    /**
     * @Fields 记录总数
     **/
    private Integer recordTotal;
    /**
     * @Fields 记录总数
     **/
    private List<AgricultureDeviceDto> list;
}
