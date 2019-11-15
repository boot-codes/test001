package com.aoscia.base.api;


import com.aoscia.base.dto.ModelDto;
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
public class ModelService implements ModelServiceApi {

    @Autowired
    private com.aoscia.base.mapper.ModelMapper ModelMapper;

    private static final Logger logger = LoggerFactory.getLogger(ModelService.class);

    @Override
    public List<ModelDto> getList(Map<String, Object> map) {
        return ModelMapper.getList(map);
    }


    @Override
    public ModelDto get(String userName) {
        return ModelMapper.get(userName);
    }

    @Override
    public void insert(ModelDto user) {
        user.setId(IdWorker.generateId());
        ModelMapper.insert(user);
    }

    @Override
    public void update(ModelDto roleDTO) {
        ModelMapper.update(roleDTO);
    }

    @Override
    public ModelDto selectById(Long id) {
        return ModelMapper.selectById(id);
    }

    @Override
    public void delete(List<Long> ids) {
        ModelMapper.delete(ids);
    }

    @Override
    public void updateById(Map<String, Object> map) {
        ModelMapper.updateById(map);
    }
    @Override
    public int getListCount(Map<String, Object> map) {
        return ModelMapper.getListCount(map);
    }
}
























