package com.aoscia.base.api;


import com.aoscia.base.dto.DictDto;
import com.aoscia.base.mapper.DictMapper;
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
public class DictService implements DictServiceApi {

    @Autowired
    private DictMapper dictMapper;

    private static final Logger logger = LoggerFactory.getLogger(DictService.class);

    @Override
    public List<DictDto> getList(Map<String, Object> map) {
        return dictMapper.getList(map);
    }


    @Override
    public DictDto get(String userName) {
        return dictMapper.get(userName);
    }

    @Override
    public void insert(DictDto user) {
        user.setId(IdWorker.generateId());
        dictMapper.insert(user);
    }

    @Override
    public void update(DictDto roleDTO) {
        dictMapper.update(roleDTO);
    }

    @Override
    public DictDto selectById(Long id) {
        return dictMapper.selectById(id);
    }

    @Override
    public void delete(List<Long> ids) {
        dictMapper.delete(ids);
    }

    @Override
    public void updateById(Map<String, Object> map) {
        dictMapper.updateById(map);
    }

    @Override
    public int getListCount(Map<String, Object> map) {
        return dictMapper.getListCount(map);
    }

    @Override
    public List<DictDto> getById(String type) {
        if (type.equals("1")) {
            type = "equipment_type";
        }
        if (type.equals("2")) {
            type = "role_type";
        }
        if (type.equals("3")) {
            type = "monitoring_items";
        }
        return dictMapper.getById(type);
    }
}
























