package com.aoscia.base.mapper;

import com.aoscia.base.dto.FightingWaterDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/**
 * @program: aosica-base->FigthingWaterMapper
 * @description: 消防水源接口
 * @author: dwj
 * @create: 2019-09-26 15:18
 **/
@Mapper
public interface FightingWaterMapper {

    /**
     * @desc 获取当前项目下消防水源
     * @param fightingWater
     * @return List<BuildingDto>
     */
    List<FightingWaterDto> queryList(HashMap<String,Object> fightingWater );

    /**
     * @desc 获取当前项目下消防水源
     * @param fightingWater
     * @return
     */

    Integer queryCount(HashMap<String,Object> fightingWater );

    /**
     * @desc 新增消防水源
     * @param fightingWaterDto
     */
    void insert(FightingWaterDto fightingWaterDto);

    /**
     * @desc 修改消防水源
     * @param fightingWaterDto
     */
    void update(FightingWaterDto fightingWaterDto);

    /**
     * @desc 查看消防水源详情信息
     * @param id
     * @return
     */
    FightingWaterDto queryById(@RequestParam(value = "id") String id);

    /**
     * @desc 删除消防水源
     * @param id
     */
    void remove(@RequestParam(value = "id") String id);
}
