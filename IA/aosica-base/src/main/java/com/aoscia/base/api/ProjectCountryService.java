package com.aoscia.base.api;


import com.aoscia.base.dto.CountryDto;
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
public class ProjectCountryService implements ProjectCountryServiceApi {

    @Autowired
    private com.aoscia.base.mapper.ProjectCountryMapper ProjectCountryMapper;

    private static final Logger logger = LoggerFactory.getLogger(ProjectCountryService.class);

    @Override
    public List<CountryDto> getList(Map<String, Object> map) {
        return ProjectCountryMapper.getList(map);
    }


    @Override
    public CountryDto get(String userName) {
        return ProjectCountryMapper.get(userName);
    }

    @Override
    public void insert(CountryDto user) {
        user.setId(IdWorker.generateId());
        ProjectCountryMapper.insert(user);
    }

    @Override
    public void update(CountryDto roleDTO) {
        ProjectCountryMapper.update(roleDTO);
    }

    @Override
    public CountryDto selectById(Long id) {
        return ProjectCountryMapper.selectById(id);
    }

    @Override
    public void delete(List<Long> ids) {
        ProjectCountryMapper.delete(ids);
    }

    @Override
    public void updateById(Map<String, Object> map) {
        ProjectCountryMapper.updateById(map);
    }

    @Override
    public int getListCount(Map<String, Object> map) {
        return ProjectCountryMapper.getListCount(map);
    }
}
























