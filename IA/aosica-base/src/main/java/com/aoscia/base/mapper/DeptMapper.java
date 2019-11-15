package com.aoscia.base.mapper;
import com.aoscia.base.dto.DeptDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @program: aosica-base->DeptService
 * @description: 机构接口
 * @author: ylp
 * @create: 2019-08-21 19:05
 **/
@Repository
public interface DeptMapper {

    /**
     * @desc 获取当前用户下的机构信息
     * @param projectId
     * @return
     */
    List<DeptDto> queryListByUserId(String projectId);

    /**
     * @desc 新增机构信息
     * @param deptDto
     */
    void insert(DeptDto deptDto);
}
