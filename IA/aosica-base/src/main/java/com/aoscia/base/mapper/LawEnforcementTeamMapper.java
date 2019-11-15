package com.aoscia.base.mapper;

import com.aoscia.base.dto.LawEnforcementTeamDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: aosica-base->LawEnforcementTeamMapper
 * @description: 执法队伍接口
 * @author: dwj
 * @create: 2019-09-26 15:18
 **/
@Mapper
public interface LawEnforcementTeamMapper {

    /**
     * @desc 获取当前项目下执法队伍
     * @param lawEnforcementTeamDto
     * @return List<BuildingDto>
     */
    Page<LawEnforcementTeamDto> queryList(LawEnforcementTeamDto lawEnforcementTeamDto);

    /**
     * @desc 获取当前项目下执法队伍数量
     * @param lawEnforcementTeamDto
     * @return
     */
   /* int queryCount(LawEnforcementTeamDto lawEnforcementTeamDto);
*/
    /**
     * @desc 新增执法队伍
     * @param lawEnforcementTeamDto
     */
    void insert(LawEnforcementTeamDto lawEnforcementTeamDto);

    /**
     * @desc 修改执法队伍
     * @param lawEnforcementTeamDto
     */
    void update(LawEnforcementTeamDto lawEnforcementTeamDto);

    /**
     * @desc 查看执法队伍详情信息
     * @param id
     * @return
     */
    LawEnforcementTeamDto queryById(@RequestParam(value = "id") String id);

    /**
     * @desc 删除执法队伍
     * @param id
     */
    void remove(@RequestParam(value = "id") String id);
}
