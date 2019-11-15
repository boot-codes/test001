package com.aosica.user.api;



import com.aosica.common.config.IdWorker;
import com.aosica.user.dto.RoleDto;
import com.aosica.user.mapper.RoleMapper;
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
public class RoleService implements RoleServiceApi {

    @Autowired
    private RoleMapper roleMapper;

    private static final Logger logger = LoggerFactory.getLogger(RoleService.class);

    @Override
    public List<RoleDto> getList(Map<String, Object> map) {
        return roleMapper.getList(map);
    }


    @Override
    public RoleDto get(String userName) {
        return roleMapper.get(userName);
    }

    @Override
    public void insert(RoleDto user) {
        user.setId(IdWorker.generateId());
        roleMapper.insert(user);
    }

    @Override
    public void update(RoleDto roleDTO) {
        roleMapper.update(roleDTO);
    }

    @Override
    public RoleDto selectById(Long id) {
        return roleMapper.selectById(id);
    }

    @Override
    public void delete(List<Long> ids) {
        roleMapper.delete(ids);
    }

    @Override
    public void updateById(Map<String, Object> map) {
        roleMapper.updateById(map);
    }

    @Override
    public int getListCount(Map<String, Object> map) {
        return roleMapper.getListCount(map);
    }
}
























