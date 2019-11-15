package com.aoscia.base.service.impl;

import com.aoscia.base.dto.BuildingDto;
import com.aoscia.base.dto.FireHydrantDto;
import com.aoscia.base.mapper.FireHydrantMapper;
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
 * @program: ai-planting->FireHydrantServiceImpl
 * @description: 消防栓实现类
 * @author: dwj
 * @create: 2019-09-27 16:50
 **/
@Service
public class FireHydrantServiceImpl implements ManageService<FireHydrantDto> {
    @Autowired
    private FireHydrantMapper mapper;

    /**
     * @desc 消防栓列表
     * @param dto
     * @return
     */
    @Override
    public Page<FireHydrantDto> selectList(FireHydrantDto dto) {
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
        System.out.println("id:"+id);
        if(StringUtils.isBlank(id)){
            throw new AosicaException("消防栓Id不能为空");
        }
        System.out.println("查询详细信息之前");
        FireHydrantDto dto = mapper.queryById(id);
        System.out.println("查询详细信息之后");
        return RequestResult.buildOkData(dto);
    }


    /**
     * @desc 新增或修改消防栓
     * @param fireHydrantDto
     * @return
     */
    @Override
    public RequestResult saveAndUpdate(FireHydrantDto fireHydrantDto) {
        long id = fireHydrantDto.getId();
        if(id == 0){
            id = IdWorker.generateId();
            fireHydrantDto.setId(id);
            fireHydrantDto.setCreateTime(new Date());
            mapper.insert(fireHydrantDto);
        }else {
            fireHydrantDto.setUpdateTime(new Date());
            mapper.update(fireHydrantDto);
        }
        return RequestResult.buildOK();
    }

    /**
     * @desc 删除消防栓
     * @param id
     * @return
     */
    @Override
    public RequestResult remove(String id) {
        System.out.println("删除消防栓之前");
        mapper.remove(id);
        System.out.println("删除消防栓之后");
        return  RequestResult.buildOK();
    }
}
