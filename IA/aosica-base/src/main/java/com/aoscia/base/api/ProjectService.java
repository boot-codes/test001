package com.aoscia.base.api;


import com.aoscia.base.dto.ProjectDto;
import com.aosica.common.config.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @PackgeName com.aosica.ai.planting.service
 * @ClassName UserService.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/8/15 9:50
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/8/15$ 9:50$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@RestController
public class ProjectService implements ProjectServiceApi {

    @Autowired
    private com.aoscia.base.mapper.ProjectMapper ProjectMapper;

    private static final Logger logger = LoggerFactory.getLogger(ProjectService.class);

    @Override
    public List<ProjectDto> getList(Map<String, Object> map) {
        return ProjectMapper.getList(map);
    }


    @Override
    public ProjectDto get(String userName) {
        return ProjectMapper.get(userName);
    }

    @Override
    public void insert(ProjectDto user) {
        user.setId(IdWorker.generateId());
        ProjectMapper.insert(user);
    }

    @Override
    public void update(ProjectDto roleDTO) {
        ProjectMapper.update(roleDTO);
    }

    @Override
    public ProjectDto selectById(Long id) {
        return ProjectMapper.selectById(id);
    }

    @Override
    public void delete(List<Long> ids) {
        ProjectMapper.delete(ids);
    }

    @Override
    public void updateById(Map<String, Object> map) {
        ProjectMapper.updateById(map);
    }

    @Override
    public int getListCount(Map<String, Object> map) {
        return ProjectMapper.getListCount(map);
    }
}
























