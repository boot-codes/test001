package com.aoscia.base.service.impl;

import com.aoscia.base.dto.LawEnforcementTeamDto;
import com.aoscia.base.dto.RescueTeamDto;
import com.aoscia.base.mapper.RescueTeamMapper;
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
 * @program: ai-planting->RescueTeamServiceImpl
 * @description: 救援队伍服务实现类
 * @author: dwj
 * @create: 2019-09-27 14:52
 **/
@Service
public class RescueTeamServiceImpl implements ManageService<RescueTeamDto> {
    @Autowired
    private RescueTeamMapper mapper;

    /**
     * @desc 救援队伍列表
     * @param dto
     * @return
     */
    @Override
    public Page<RescueTeamDto> selectList(RescueTeamDto dto) {
        System.out.println("进入FireWaterServiceImpl------4-----");
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize()) ;
        return this.mapper.queryList(dto);
    }

    /**
     * @desc 查看详情
     * @param id
     * @return
     */
    @Override
    public RequestResult selectDetailById(String id) {
        if(StringUtils.isBlank(id)){
            throw new AosicaException("救援队伍Id不能为空");
        }
        RescueTeamDto dto = mapper.queryById(id);
        return RequestResult.buildOkData(dto);
    }

    /**
     * @desc 新增或修改救援队伍
     * @param rescueTeamDto
     * @return
     */
    @Override
    public RequestResult saveAndUpdate(RescueTeamDto rescueTeamDto) {
        long id = rescueTeamDto.getId();
        if(id == 0){
            id = IdWorker.generateId();
            rescueTeamDto.setId(id);
            rescueTeamDto.setCreateTime(new Date());
            mapper.insert(rescueTeamDto);
        }else {
            rescueTeamDto.setUpdateTime(new Date());
            mapper.update(rescueTeamDto);
        }
        return RequestResult.buildOK();
    }

    /**
     * @desc 删除救援队伍
     * @param id
     * @return
     */
    @Override
    public RequestResult remove(String id) {
        mapper.remove(id);
        return  RequestResult.buildOK();
    }
}
