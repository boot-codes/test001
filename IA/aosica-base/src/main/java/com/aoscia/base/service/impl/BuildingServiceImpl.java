package com.aoscia.base.service.impl;

import com.aoscia.base.dto.BuildingDto;
import com.aoscia.base.dto.FireWaterDto;
import com.aoscia.base.mapper.BuildingMapper;
import com.aoscia.base.service.BuildingService;
import com.aoscia.base.service.ManageService;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.config.IdWorker;
import com.aosica.common.exception.AosicaException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @program: aosica-base->BuildingServiceImpl
 * @description: 建筑物实现类
 * @author: dwj
 * @create: 2019-09-24 10:10
 **/
@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingMapper mapper;

    /**
     * @desc 获取建筑物列表
     * @param dto
     * @return
     */
    @Override
    public Page<BuildingDto> selectList(BuildingDto dto) {
        System.out.println("进入FireWaterServiceImpl------4-----");
        System.out.println(dto);
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize()) ;
        return this.mapper.queryList(dto);
    }


    /**
     * @desc 查看建筑物详情信息
     * @param id
     * @return
     */
    @Override
    public RequestResult<BuildingDto> selectDetailById(String id) {
        System.out.println("进入FireWaterServiceImpl------4-----");
        if(StringUtils.isBlank(id)){
            throw new AosicaException("建筑物Id不能为空");
        }
        BuildingDto dto = mapper.queryById(id);
        System.out.println(dto);
        return RequestResult.buildOkData(dto);
    }

    /**
     * @desc 删除建筑物
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = AosicaException.class)
    public RequestResult remove(String id) {
        mapper.remove(id);
        return RequestResult.buildOK();
    }

    /**
     * @desc 新增建筑物
     * @param dto
     * @return
     */
    @Override
    @Transactional(rollbackFor = AosicaException.class)
    public RequestResult insert(BuildingDto dto) {
        long id = IdWorker.generateId();
        dto.setId(id);
        dto.setCreateTime(new Date());
        mapper.insert(dto);
        return RequestResult.buildOK();
    }

    /**
     * @desc 更新建筑物信息
     * @param dto
     * @return
     */
    @Override
    @Transactional(rollbackFor = AosicaException.class)
    public RequestResult update(BuildingDto dto) {
        dto.setUpdateTime(new Date());
        mapper.update(dto);
        return RequestResult.buildOK();
    }
}
