package com.aosica.user.api;


import com.aosica.common.bean.RequestResult;
import com.aosica.user.dto.MenuDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 菜单管理  Service
 *
 * @PackgeName com.aoscia.base.api
 * @ClassName MenuService.java
 * @Description: TODO
 * @Author: ylp
 * @Date: 2019/8/25 9:41
 * @UpdateUser: ylp
 * @UpdateDate: 2019/8/25$ 9:41$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@RequestMapping("menu")
public interface MenuServiceApi {


    /**
     * @description 获取当前用户所有菜单
     * @param userId
     */
    @ApiOperation(value = "获取当前用户所有菜单",notes = "")
    @ApiImplicitParam(name = "用户id",value = "userId")
    @PostMapping("selectAuthAllMenu")
    RequestResult selectAuthAllMenu(@RequestParam(value = "userId") String userId);

    /**
     * @description 新增菜单
     * @param menuDto
     */
    @ApiOperation(value = "新增菜单",notes = "")
    @ApiImplicitParam(dataTypeClass = MenuDto.class)
    @PostMapping("save")
    RequestResult save(MenuDto menuDto);

}
