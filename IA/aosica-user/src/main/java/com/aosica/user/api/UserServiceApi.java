package com.aosica.user.api;


import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.user.dto.LoginUserDTO;
import com.aosica.user.dto.UserDto;
import com.aosica.user.dto.UserLoginDTO;
import com.aosica.user.dto.UserQueryDto;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackgeName com.aosica.ai.planting.service
 * @ClassName UserService.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/8/15 9:50
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/8/15$ 9:50$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@RestController
public class UserServiceApi implements UserApi{


    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceApi.class);


    /**
     * 根据查询条件，查询用户列表。可以返回多条用户列表。
     *
     * @param userQueryDto
     * @return List<UserDTO>
     * @description 设备列表
     */
    @Override
    public RequestResultPage<Page<UserDto>> getList(UserQueryDto userQueryDto) {
        return null;
    }

    /**
     * 用户登录
     *
     * @param userLoginDto
     * @return
     */
    @Override
    public RequestResult<LoginUserDTO> login(UserLoginDTO userLoginDto) {
        return null;
    }

    /**
     * @param id 用户id
     * @return UserDTO
     * @description 根据 ueer id 查询用户信息。
     */
    @Override
    public RequestResult<UserDto> getUserById(Long id) {
        return null;
    }


}
























