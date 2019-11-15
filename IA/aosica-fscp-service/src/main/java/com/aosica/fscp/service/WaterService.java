package com.aosica.fscp.service;


import com.aoscia.base.dto.FightingWaterDto;
import com.aosica.common.bean.RequestResult;

import java.util.List;

public interface WaterService {
    //查询水源列表
    RequestResult<List<FightingWaterDto>> getList(FightingWaterDto dto);

}
