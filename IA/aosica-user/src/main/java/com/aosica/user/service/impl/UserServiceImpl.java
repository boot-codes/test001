package com.aosica.user.service.impl;

import com.aosica.common.config.IdWorker;
import com.aosica.common.util.EncryptUtils;
import com.aosica.common.util.JwtUtil;
import com.aosica.user.dto.*;
import com.aosica.user.entity.User;
import com.aosica.user.mapper.UserMapper;
import com.aosica.user.service.UserService;
import com.github.pagehelper.Page;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *  用户管理 service
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper ;


    /**
     * 创建用户
     *
     * @param dto
     * @return
     */
    @Override
    public User createUser(UserInfoDto dto) throws Exception {

        User userByAccount = getUserByAccount(dto.getAccount());
        if(userByAccount != null) {
            return  null ;
        }
        User user = buildUser(dto)  ;
        this.userMapper.save(user);
        return  user ;
    }


    /**
     *
     * @return
     */
    public User buildUser(UserInfoDto dto) throws Exception {

        User user = new User() ;
        BeanUtils.copyProperties(user,dto);

        user.setPassword(EncryptUtils.getDigest(user.getPassword(),EncryptUtils.getSalt()));
        user.setId(IdWorker.generateId());
        user.setSalt(EncryptUtils.getSalt());
        user.setCreateTime(new Date());
        // 用户有效
        user.setStatus(1);

        return  user ;
    }


    /**
     * 用户登录
     *
     * @param userLoginDto
     * @return
     */
    @Override
    public LoginUserDTO login(UserLoginDTO userLoginDto) throws Exception {

        User userByAccount  = getUserByAccount(userLoginDto.getAccount()) ;
        if(userByAccount == null ) {
            return  null ;
        }

        String account = userByAccount.getAccount() ;
        // 用户输入的密码
        String userInputPassword = userLoginDto.getPassword() ;

        // 数据库里存的用户密码，加密后的密文
        String dbUserPassword = userByAccount.getPassword() ;
        String digest = EncryptUtils.getDigest(userInputPassword, userByAccount.getSalt());

        // 密码错误
        if(!dbUserPassword.equals(digest)) {
            return  null ;
        }
        // 返回用户登录后的信息
        return buildLoginUserDTO(account ,userByAccount.getId()) ;
    }

    /**
     * 构建 LoginUserDTO 对象
     * @param account
     * @param uerId
     * @return
     * @throws Exception
     */
    private LoginUserDTO  buildLoginUserDTO(String account ,Long uerId) throws Exception {

        LoginUserDTO   dto = new LoginUserDTO() ;
        dto.setAccount(account);
        dto.setUserId(uerId);
        dto.setToken(JwtUtil.generateToken(account));
        return dto ;
    }

    /**
     * 根据用户账号查询用户
     *
     * @param account
     * @return
     */
    @Override
    public User getUserByAccount(String account) {

        User userByAccount  ;

        // 没有找到对应账号的用户
        if(StringUtils.isBlank(account) || (userByAccount = this.userMapper.getUserByAccount(account)) ==null ) {
            return  null ;
        }
        return  userByAccount ;
    }


    /**
     * 根据查询条件，查询用户列表。可以返回多条用户列表。
     *
     * @param userQueryDto
     * @return List<UserDTO>
     */
    @Override
    public Page<UserDto> getList(UserQueryDto userQueryDto) {
        return null;
    }




    /**
     * @param id 用户id
     * @return UserDTO
     * @description 根据 ueer id 查询用户信息。
     */
    @Override
    public UserDto getUserById(Long id) {
        return null;
    }



}
