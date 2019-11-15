package com.aoscia.base.service.impl;

import com.aoscia.base.dto.FireWaterDto;
import com.aoscia.base.mapper.FireWaterMapper;
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
 * @program: ai-planting->FireWaterServiceImpl
 * @description: 消防水源
 * @author: ll
 * @create: 2019-11-04 18:04
 **/

@Service
public class FireWaterServiceImpl implements ManageService<FireWaterDto> {

    @Autowired
    private FireWaterMapper mapper;

    /**
     * 根据查询对象，查询数据
     *
     * @param dto
     * @return
     */
    @Override
    public Page<FireWaterDto> selectList(FireWaterDto dto) {
        System.out.println("进入FireWaterServiceImpl------4-----");
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize()) ;
        return this.mapper.queryList(dto);
    }




    @Override
    public RequestResult<FireWaterDto> selectDetailById(String id) {
        if(StringUtils.isBlank(id)){
            throw new AosicaException("水源Id不能为空");
        }
        System.out.println("-----查看消防水源详细信息之前-----");
        FireWaterDto dto = mapper.queryById(id);
        System.out.println(dto);
        System.out.println("-----查看消防水源详细信息之后-----");
        return RequestResult.buildOkData(dto);
    }


    @Override
    public RequestResult saveAndUpdate(FireWaterDto dto) {
        System.out.println("-----进入FigthingWaterServiceImpl--6-------");
        System.out.println(dto);
        long id = dto.getId();
        if(id == 0){
            id = IdWorker.generateId();
            dto.setId(id);
            dto.setCreateTime(new Date());
            System.out.println("-----插入水源之前-----");
            mapper.insert(dto);
            System.out.println("-----插入水源之后-----");
        }else {
            dto.setUpdateTime(new Date());
            System.out.println("-----更新水源之前-----");
            mapper.update(dto);
        }
        return RequestResult.buildOK();
    }

    @Override
    public RequestResult remove(String id) {
        System.out.println("-----删除水源之前-----");
        mapper.remove(id);
        return  RequestResult.buildOK();
    }
}
