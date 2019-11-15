package com.aoscia.base.service.impl;

import com.aoscia.base.dto.FireHydrantDto;
import com.aoscia.base.dto.LawEnforcementTeamDto;
import com.aoscia.base.mapper.LawEnforcementTeamMapper;
import com.aoscia.base.service.ManageService;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.config.IdWorker;
import com.aosica.common.exception.AosicaException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: ai-planting->LawEnforcementTeamServiceImpl
 * @description: 执法队伍实现类
 * @author: dwj
 * @create: 2019-09-27 16:07
 **/
@Service
public class LawEnforcementTeamServiceImpl implements ManageService<LawEnforcementTeamDto> {

    @Autowired
    private LawEnforcementTeamMapper mapper;

    /**
     * @desc 执法队伍列表
     * @param dto
     * @return
     */
    @Override
    public Page<LawEnforcementTeamDto> selectList(LawEnforcementTeamDto dto) {
        System.out.println("进入FireWaterServiceImpl------4-----");
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize()) ;
        return this.mapper.queryList(dto);
    }

    /**
     * @desc 执法队伍详情
     * @param id
     * @return
     */
    @Override
    public RequestResult selectDetailById(String id) {
        if(StringUtils.isBlank(id)){
            throw new AosicaException("执法队伍Id不能为空");
        }
        LawEnforcementTeamDto dto = mapper.queryById(id);
        return RequestResult.buildOkData(dto);
    }

    /**
     * @desc 新增或修改执法队伍
     * @param lawEnforcementTeamDto
     * @return
     */
    @Override
    public RequestResult saveAndUpdate(LawEnforcementTeamDto lawEnforcementTeamDto) {
        long id = lawEnforcementTeamDto.getId();
        System.out.println(id);
        if(id == 0){
            id = IdWorker.generateId();
            lawEnforcementTeamDto.setId(id);
            lawEnforcementTeamDto.setCreateTime(new Date());
            mapper.insert(lawEnforcementTeamDto);
        }else {
            lawEnforcementTeamDto.setUpdateTime(new Date());
            mapper.update(lawEnforcementTeamDto);
        }
        return RequestResult.buildOK();
    }

    /**
     * @desc 删除执法队伍
     * @param id
     * @return
     */
    @Override
    public RequestResult remove(String id) {
        mapper.remove(id);
        return  RequestResult.buildOK();
    }
}
