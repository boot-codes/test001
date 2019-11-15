package com.aoscia.base.mapper;

import com.aoscia.base.dto.FireWaterDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface FireWaterMapper {

    /**
     * @desc 获取当前项目下消防水源
     * @param dto
     * @return Page<FireWaterDto>
     */
    Page<FireWaterDto> queryList(FireWaterDto dto);


    /**
     * @desc 新增消防水源
     * @param dto
     */

    void insert(FireWaterDto dto);

    /**
     * @desc 修改消防水源
     * @param dto
     */
    void update(FireWaterDto dto);


    /**
     * @desc 查看消防水源详情信息
     * @param id
     * @return
     */
    FireWaterDto queryById(@RequestParam(value = "id") String id);


    /**
     * @desc 删除消防水源
     * @param id
     */
    void remove(@RequestParam(value = "id") String id);
}
