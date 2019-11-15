package com.aoscia.base.service.impl;

import com.aoscia.base.dto.FireHydrantDto;
import com.aoscia.base.dto.FireLedgerDto;
import com.aoscia.base.mapper.FireLedgerMapper;
import com.aoscia.base.service.ManageService;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.config.IdWorker;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: ai-planting->FireLedgerService
 * @description: 消防台账Service
 * @author: ll
 * @create: 2019-11-04 10:35
 **/

@Service
public class FireLedgerServiceImpl implements ManageService<FireLedgerDto> {

    @Autowired
    private FireLedgerMapper mapper;


    @Override
    public Page<FireLedgerDto> selectList(FireLedgerDto dto) {
        System.out.println("FireLedgerServiceImpl------4-----");
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize()) ;
        System.out.println("查询列表之前");
        return this.mapper.queryList(dto);
    }

    @Override
    public RequestResult<FireLedgerDto> selectDetailById(String id) {
        return null;
    }

    @Override
    public RequestResult saveAndUpdate(FireLedgerDto dto) {
        long id = dto.getId();
        if(id == 0){
            id = IdWorker.generateId();
            dto.setId(id);
            dto.setCreateTime(new Date());
            mapper.insert(dto);
        }else {
            dto.setUpdateTime(new Date());
            mapper.update(dto);
        }
        return RequestResult.buildOK();
    }

    @Override
    public RequestResult remove(String id) {
        return null;
    }


}
