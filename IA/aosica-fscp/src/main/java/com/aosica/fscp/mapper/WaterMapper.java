package com.aosica.fscp.mapper;

import com.aosica.fscp.api.dto.QueryWaterListDto;
import com.aosica.fscp.api.dto.WaterQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WaterMapper {

        /**
         * TODO 功能描述: 查询水源-返回水源信息列表
         * @param dto 查询条件
         * @return 列表数据
         */
        List<QueryWaterListDto> getList(WaterQueryDto dto);
    }
