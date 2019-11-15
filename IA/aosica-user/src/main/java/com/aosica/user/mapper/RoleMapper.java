package com.aosica.user.mapper;

import com.aosica.user.dto.RoleDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @program: aosica-base->RoleService
 * @description: 角色接口
 * @author: ylp
 * @create: 2019-08-21 19:05
 **/
@Repository
public interface RoleMapper {

    void insert(RoleDto roleDTO);

    RoleDto get(String userName);

    void update(RoleDto roleDTO);

    RoleDto selectById(Long id);

    List<RoleDto> getList(Map<String, Object> map);

    void updateById(Map<String, Object> map);

    void delete(List<Long> ids);

    int getListCount(Map<String, Object> map);
}
