package com.aoscia.base.mapper;

import com.aoscia.base.dto.FireLedgerDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
/**
 * @program: aosica-base->FireHydrantMapper
 * @description: 消防台账接口
 * @author: ll
 * @create: 2019-09-26 15:18
 **/
@Mapper
public interface FireLedgerMapper {
    /**
     * @desc 获取当前项目下消防台账
     * @param fireLedgerDto
     * @return List<FireLedgerDto>
     */
    Page<FireLedgerDto> queryList(FireLedgerDto fireLedgerDto);

    /**
     * @desc 获取当前项目下消防台账数量
     * @param fireLedgerDto
     * @return
     */
    int queryCount(FireLedgerDto fireLedgerDto);

    /**
     * @desc 新增消防台账
     * @param fireLedgerDto
     */
    void insert(FireLedgerDto fireLedgerDto);

    /**
     * @desc 修改消防台账
     * @param fireLedgerDto
     */
    void update(FireLedgerDto fireLedgerDto);

    /**
     * @desc 查看消防台账详情信息
     * @param id
     * @return
     *//*
    FireLedgerDto queryById(@RequestParam(value = "id") String id);*/

   /* *//**
     * @desc 删除消防台账
     * @param id
     *//*
    void remove(@RequestParam(value = "id") Object id);*/

}
