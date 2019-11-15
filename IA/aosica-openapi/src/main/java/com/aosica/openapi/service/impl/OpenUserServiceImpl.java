package com.aosica.openapi.service.impl;

import com.aosica.openapi.api.util.ObjectUtil;
import com.aosica.openapi.dto.OpenUser;
import com.aosica.openapi.service.OpenUserService;
import com.aosica.openapi.util.JwtUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 开放接口平台 用户service 接口实现
 * @PackgeName com.aosica.openapi.service.impl
 * @ClassName OperUserServiceImpl.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/10/24 11:25
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/10/24$ 11:25$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@Service
public class OpenUserServiceImpl implements OpenUserService {


    public final static String SPECIAL_CHARACTER="[\\s~·`!！@#￥$%^……&*（()）\\-——\\-_=+【\\[\\]】｛{}｝\\|、\\\\；;：:‘'“”\"，,《<。.》>、/？?]";


    /**
     * 创建 open user  : 包含 user id 和 user secret .
     * @return
     */
    @Override
    public OpenUser createOpenUser() throws Exception {
        String userId = getUserId();
        String userSecret = getUserSecret(userId);
        OpenUser openUser = new OpenUser() ;
        openUser.setUserId(userId);
        openUser.setSecret(userSecret);
        openUser.setCreateTime(System.currentTimeMillis());

        return openUser ;
    }

    /**
     * 生成开放平台用户id
     *
     * @return
     */
    @Override
    public String getUserId() throws Exception {

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        Md5Hash md5 = new Md5Hash(uuid);
        return replaceSpecStr(md5.toBase64()) ;
    }




    /**
     * 生成用户id 对应的 token
     *
     * @param userId
     * @return
     */
    @Override
    public String getUserSecret(String userId) throws Exception {
        ObjectUtil.checkNotEmpty(userId,"userId 不能为空") ;
        String token = JwtUtil.generateToken(userId);
        return token;
    }




    /**
     * 正则替换所有特殊字符
     * @param orgStr
     * @return
     */
    public String replaceSpecStr(String orgStr)  {

        ObjectUtil.checkNotEmpty(orgStr,"参数不能为空") ;
        Pattern p = Pattern.compile(SPECIAL_CHARACTER);
        Matcher m = p.matcher(orgStr);
        return  m.replaceAll("");
    }





}
