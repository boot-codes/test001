package com.aosica.lot.vo;

import com.aosica.lot.dto.LogDto;
import lombok.Data;

import java.util.List;

/**
 * @program: ai-planting->OperationVo
 * @description:
 * @author: dwj
 * @create: 2019-09-09 14:10
 **/
@Data
public class OperationVo {

    /**
     * @Fields 记录总数
     **/
    private Integer recordTotal;
    /**
     * @Fields 记录总数
     **/
    private List<LogDto> list;
}
