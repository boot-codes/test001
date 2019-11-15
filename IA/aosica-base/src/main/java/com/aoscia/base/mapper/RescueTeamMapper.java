package com.aoscia.base.mapper;

import com.aoscia.base.dto.RescueTeamDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: aosica-base->RescueTeamMapper
 * @description: 救援队伍接口
 * @author: dwj
 * @create: 2019-09-26 15:18
 **/
@Mapper
public interface RescueTeamMapper {
    /**
     * @desc 获取当前项目下救援队伍
     * @param rescueTeamDto
     * @return List<BuildingDto>
     */
    Page<RescueTeamDto> queryList(RescueTeamDto rescueTeamDto);

    /**
     * @desc 获取当前项目下救援队伍数量
     * @param rescueTeamDto
     * @return
     */
   // int queryCount(RescueTeamDto rescueTeamDto);

    /**
     * @desc 新增救援队伍
     * @param rescueTeamDto
     */
    void insert(RescueTeamDto rescueTeamDto);

    /**
     * @desc 修改救援队伍
     * @param rescueTeamDto
     */
    void update(RescueTeamDto rescueTeamDto);

    /**
     * @desc 查看救援队伍详情信息
     * @param id
     * @return
     */
    RescueTeamDto queryById(@RequestParam(value = "id") String id);

    /**
     * @desc 删除救援队伍
     * @param id
     */
    void remove(@RequestParam(value = "id") String id);
}
