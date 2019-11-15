package com.aosica.user.api;


import com.aosica.user.dto.RoleDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 角色管理  Service
 *
 * @PackgeName com.aoscia.base.api
 * @ClassName RoleService.java
 * @Description: TODO
 * @Author: ylp
 * @Date: 2019/8/25 9:41
 * @UpdateUser: ylp
 * @UpdateDate: 2019/8/25$ 9:41$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@RequestMapping("/role")
public interface RoleServiceApi {

    /**
     * @param map
     * @return List<RoleDTO>
     * @description 设备列表
     */
    @GetMapping("/list")
    List<RoleDto> getList(Map<String, Object> map);

    RoleDto get(String userName);

    void insert(RoleDto roleDTO);

    void update(RoleDto roleDTO);

    /**
     * @param id
     * @return UserDTO
     * @description 查询用户详细信息
     */
    @RequestMapping("selectById")
    RoleDto selectById(Long id);

    void delete(List<Long> ids);

    /**
     * @param map
     * @return List<UserDTO>
     * @description 设备列表
     */
    //@GetMapping("/list")
    void updateById(Map<String, Object> map);

    int getListCount(Map<String, Object> map);
}
