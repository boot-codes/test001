package com.aosica.fscp.service.impl;

import com.aoscia.base.dto.FightingWaterDto;
import com.aosica.common.bean.RequestResult;
import com.aosica.fscp.api.dto.QueryWaterListDto;
import com.aosica.fscp.mapper.WaterMapper;
import com.aosica.fscp.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: ai-planting->WaterService
 * @description: 水源信息Service
 * @author: liuli
 * @create: 2019-10-30 18:04
 **/
@Service
public class WaterServiceImpl implements WaterService {
    @Override
    public RequestResult<List<FightingWaterDto>> getList(FightingWaterDto dto) {
        return null;
    }

   /* @Autowired
    private Fighting

    @Override
    public RequestResult<List<FightingWaterDto>> getList(FightingWaterDto dto) {
        RequestResult<List<QueryWaterListDto>> result = new RequestResult<>();
        List<QueryWaterListDto> waterlist = mapper.getList(dto);
        result.setStatus(200);
        result.setData(waterlist);
        return result;
    }*/
}
