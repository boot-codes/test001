package com.aosica.openapi.service;


import com.aosica.openapi.dto.OpenUser;

/**
 *  开放接口平台 用户service
 * @PackgeName com.aosica.openapi.service
 * @ClassName OperUserService.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/10/24 11:23
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/10/24$ 11:23$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public interface OpenUserService {

    /**
     * 创建 开放平台用户
     * @return
     */
    OpenUser createOpenUser() throws Exception;

    /**
     * 生成开放平台用户id
     * @return
     */
    String getUserId() throws Exception ;

    /**
     *  生成用户id 对应的 secret
     * @return
     */
    String getUserSecret(String userId) throws Exception;

}
