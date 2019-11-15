package com.aoscia.base.mapper;
import com.aoscia.base.dto.ProjectDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @program: aosica-base->ProjectService
 * @description: 工程接口
 * @author: ylp
 * @create: 2019-08-21 19:05
 **/
@Repository
public interface ProjectMapper {

    void insert(ProjectDto userDTO);

    ProjectDto get(String userName);

    void update(ProjectDto userDTO);

    ProjectDto selectById(Long id);

    List<ProjectDto> getList(Map<String, Object> map);

    void updateById(Map<String, Object> map);

    void delete(List<Long> ids);

    int getListCount(Map<String, Object> map);
}
