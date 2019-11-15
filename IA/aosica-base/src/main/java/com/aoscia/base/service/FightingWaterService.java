package com.aoscia.base.service;

import com.aoscia.base.dto.FightingWaterDto;
import com.aosica.common.bean.RequestResult;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * @program: ai-planting->FigthingWaterService
 * @description: 消防水源实现类
 * @author: dwj
 * @create: 2019-09-26 15:17
 **/
public interface FightingWaterService {

    /**
     * @description 获取消防水源列表
     * @param fightingWaterDto
     */
    RequestResult selectList(FightingWaterDto fightingWaterDto);



    RequestResult list(HashMap<String,Object> map);
    /**
     * @description 获取消防水源详情信息
     * @param id
     */
    RequestResult selectDetailById(@RequestParam(value = "id")String id);

    /**
     * @description 新增或更新消防水源
     * @param fightingWaterDto
     */
    RequestResult saveAndUpdate(FightingWaterDto fightingWaterDto);


    /**
     * @description 删除消防水源
     * @param id
     */
    RequestResult remove(@RequestParam(value = "id")String id);

}
