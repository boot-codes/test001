package com.aoscia.base.api;


import com.aoscia.base.dto.AreaDto;
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
 * @Author: ylp
 * @Date: 2019/8/25 9:50
 * @UpdateUser: ylp
 * @UpdateDate: 2019/8/25$ 9:50$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@RestController
public class AreaService implements AreaServiceApi {

    @Autowired
    private com.aoscia.base.mapper.AreaMapper AreaMapper;

    private static final Logger logger = LoggerFactory.getLogger(AreaService.class);

    @Override
    public List<AreaDto> getList(Map<String, Object> map) {
        return AreaMapper.getList(map);
    }


    @Override
    public AreaDto get(String userName) {
        return AreaMapper.get(userName);
    }

    @Override
    public void insert(AreaDto user) {
        user.setId(IdWorker.generateId());
        AreaMapper.insert(user);
    }

    @Override
    public void update(AreaDto roleDTO) {
        AreaMapper.update(roleDTO);
    }

    @Override
    public AreaDto selectById(Long id) {
        return AreaMapper.selectById(id);
    }

    @Override
    public void delete(List<Long> ids) {
        AreaMapper.delete(ids);
    }

    @Override
    public void updateById(Map<String, Object> map) {
        AreaMapper.updateById(map);
    }

    @Override
    public int getListCount(Map<String, Object> map) {
        return AreaMapper.getListCount(map);
    }

    @Override
    public List<AreaDto> getChildren(String id) {
        return AreaMapper.getChildren(id);
    }

    @Override
    public Boolean isRelated(Long id) {
        return AreaMapper.isRelated(id);
    }
}
























