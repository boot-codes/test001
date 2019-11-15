package com.aoscia.base.mapper;

import com.aoscia.base.dto.FireHydrantDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: aosica-base->FireHydrantMapper
 * @description: 执法队伍接口
 * @author: dwj
 * @create: 2019-09-26 15:18
 **/
@Mapper
public interface FireHydrantMapper {

    /**
     * @desc 获取当前项目下消防栓
     * @param fireHydrantDto
     * @return List<FireHydrantDto>
     */
    Page<FireHydrantDto> queryList(FireHydrantDto fireHydrantDto);


   /* int queryCount(FireHydrantDto fireHydrantDto);*/

    /**
     * @desc 新增消防栓
     * @param fireHydrantDto
     */
    void insert(FireHydrantDto fireHydrantDto);

    /**
     * @desc 修改消防栓
     * @param fireHydrantDto
     */
    void update(FireHydrantDto fireHydrantDto);

    /**
     * @desc 查看消防栓详情信息
     * @param id
     * @return
     */
    FireHydrantDto queryById(@RequestParam(value = "id") String id);

    /**
     * @desc 删除消防栓
     * @param id
     */
    void remove(@RequestParam(value = "id") Object id);
}
