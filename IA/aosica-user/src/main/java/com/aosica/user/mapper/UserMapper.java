package com.aosica.user.mapper;

import com.aosica.user.dto.LoginUserDTO;
import com.aosica.user.dto.UserLoginDTO;
import com.aosica.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: aosica-base->UserService
 * @description: 用户接口
 * @author: ylp
 * @create: 2019-08-21 19:05
 **/
@Mapper
public interface UserMapper {


    /**
     * 根据用户登录账号，查询用户信息。
     * @param account
     * @return
     */
    User getUserByAccount(@Param("account") String  account)   ;

    boolean save(User user) ;


//    void insert(UserDto userDTO);
//
//    UserDto get(String userName, String type);
//
//    void update(UserDto userDTO);
//
//    UserDto selectById(Long id);
//
//    List<UserDto> getList(Map<String, Object> map);
//
//    void updateById(Map<String, Object> map);
//
//    void delete(List<Long> ids);
//
//    int getListCount(Map<String, Object> map);
//
//    void insertJoin(Long id, Long userId, Long roleId);
//
//    void deleteJoin(Long id);
}
