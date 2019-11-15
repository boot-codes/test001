package com.aosica.user.service.impl;


import com.aosica.common.bean.RequestResult;
import com.aosica.common.config.IdWorker;
import com.aosica.common.exception.AosicaException;
import com.aosica.user.dto.MenuDto;
import com.aosica.user.entity.MenuEntity;
import com.aosica.user.mapper.MenuMapper;
import com.aosica.user.service.MenuService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: aosica-base->MenuServiceImpl
 * @description: 菜单服务实现类
 * @author: dwj
 * @create: 2019-09-23 10:28
 **/
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    /**
     * @desc 根据用户Id查询所属菜单
     * @param userId
     * @return
     */
    @Override
    public RequestResult selectAuthAllMenu(String userId) {
        RequestResult requestResult = null;
        List<MenuDto> list = new ArrayList<MenuDto>();
        try {
            List<MenuDto> menuList = menuMapper.selectAuthAllMenu(userId);
            // 找到所有一级菜单
            menuList.forEach(entity -> {
                // 一级菜单parent_id为0
                if (MenuEntity.ONE_LEVEL_MENU.equals(entity.getParentId())) {
                    list.add(entity);
                }
            });
            // 为一级菜单设置子菜单
            if (!CollectionUtils.isEmpty(list)) {
                list.forEach(menu -> menu.setChildMenus(getChild(menu.getId(), menuList)));
            }
             requestResult = RequestResult.buildOkData(list);
        }catch (Exception e) {
            requestResult = RequestResult.build(RequestResult.FAIL_CODE,e.getMessage());
        }
        return requestResult;
    }

    /**
     * 递归查询子菜单数据
     * @param id
     * @param rootMenuList
     * @return
     */
    private List<MenuDto> getChild(String id, List<MenuDto> rootMenuList) {
            List<MenuDto> childList = new ArrayList<MenuDto>();
            for (MenuDto menuDto : rootMenuList) {
                // 遍历所有节点，将父菜单id与传过来的id比较
                if (StringUtils.isNotBlank(menuDto.getParentId())) {
                    if (menuDto.getParentId().equals(id)) {
                        childList.add(menuDto);
                    }
                }
            }
        // 把子菜单的子菜单再循环一遍
        for (MenuDto menu : childList) {
            // 没有url子菜单还有子菜单
            if (StringUtils.isBlank(menu.getUrl())) {
                // 递归
                menu.setChildMenus(getChild(menu.getId(), rootMenuList));
            }
        }
        // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }

        return childList;
    }



    /**
     * @desc 新增菜单
     * @param menuDto
     */
    @Override
    public RequestResult save(MenuDto menuDto) {
        try {
            if(StringUtils.isBlank(menuDto.getParentId())){
                menuDto.setParentId("0");
            }
            menuDto.setId(String.valueOf(IdWorker.generateId()));
            menuDto.setCreateTime(new Date());
            menuMapper.insert(menuDto);
        }
        catch (Exception e) {
            throw new AosicaException("新增菜单异常", e);
        }
        return RequestResult.buildOK();
    }
}
