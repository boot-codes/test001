package com.aosica.user.mapper;
import com.aosica.user.dto.MenuDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: aosica-base->MenuService
 * @description: 菜单接口
 * @author: ylp
 * @create: 2019-08-21 19:05
 **/
@Mapper
public interface MenuMapper {


    /**
     * @desc 新增菜单
     * @param userDTO
     */
    void insert(MenuDto userDTO);

    /**
     * @desc 查询用户所有有权限的菜单
     * @param userId
     * @return
     */
    List<MenuDto> selectAuthAllMenu(@RequestParam(value = "userId") String userId);


}
