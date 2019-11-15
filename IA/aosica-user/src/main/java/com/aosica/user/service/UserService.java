package com.aosica.user.service;


import com.aosica.user.dto.*;
import com.aosica.user.entity.User;
import com.github.pagehelper.Page;

/**
 *  用户管理service
 */
public interface UserService {


  /**
   * 创建用户
   * @return
   */
   User createUser(UserInfoDto dto) throws Exception;

   /**
     * 用户登录
     *
     * @param userLoginDto
     * @return
     */
    LoginUserDTO login(UserLoginDTO userLoginDto) throws Exception;


    /**
     *  根据用户账号查询用户
     * @param account
     * @return
     */
    User getUserByAccount(String account) ;

    /**
     * 根据查询条件，查询用户列表。可以返回多条用户列表。
     *
     * @param userQueryDto
     * @return List<UserDTO>
     */
    Page<UserDto> getList(UserQueryDto userQueryDto)  ;




    /**
     * @param id 用户id
     * @return UserDTO
     * @description 根据 ueer id 查询用户信息。
     */

    UserDto getUserById(Long id)  ;


}
