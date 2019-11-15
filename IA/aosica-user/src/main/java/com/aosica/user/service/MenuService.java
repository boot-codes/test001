package com.aosica.user.service;

import com.aosica.common.bean.RequestResult;
import com.aosica.user.dto.MenuDto;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: aosica-base->MenuService
 * @description: 菜单接口
 * @author: dwj
 * @create: 2019-09-24 10:10
 **/
public interface MenuService {


    /**
     * @description 获取当前用户所有菜单
     * @param userId
     */
    RequestResult selectAuthAllMenu(@RequestParam(value = "userId") String userId);

    /**
     * @description 新增菜单
     * @param menuDto
     */
    RequestResult save(MenuDto menuDto);
}
