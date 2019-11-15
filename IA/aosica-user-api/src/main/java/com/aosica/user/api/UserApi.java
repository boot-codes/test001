package com.aosica.user.api;


import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.user.dto.LoginUserDTO;
import com.aosica.user.dto.UserDto;
import com.aosica.user.dto.UserLoginDTO;
import com.aosica.user.dto.UserQueryDto;
import com.github.pagehelper.Page;
import org.springframework.web.bind.annotation.*;



/**
 *  用户管理 api
 */
@RequestMapping("/user")
public interface UserApi {


    /**
     * 用户登录
     * @return
     */
    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    RequestResult<LoginUserDTO> login(@RequestBody UserLoginDTO userLoginDto ) ;

    /**
     *  根据查询条件，查询用户列表。可以返回多条用户列表。
     * @param userQueryDto
     * @return List<UserDTO>
     * @description 设备列表
     */
    @RequestMapping(value = "/list" , method = RequestMethod.POST)
    RequestResultPage<Page<UserDto>> getList(@RequestBody UserQueryDto userQueryDto);



    /**
     * @param id 用户id
     * @return UserDTO
     * @description 根据 ueer id 查询用户信息。
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    RequestResult<UserDto> getUserById(@PathVariable Long id);


//    UserDto get(String userName, String type);
//
//    void insert(UserDto user, Long[] roleIds);
//
//    void update(UserDto user, Long[] roleIds);



//    void delete(List<Long> ids);

    /**
     * @param map
     * @return List<UserDTO>
     * @description 设备列表
     */
    //@GetMapping("/list")
//    void updateById(Map<String, Object> map);
//
//    int getListCount(Map<String, Object> map);
//
//    void back(UserDto user);


}
