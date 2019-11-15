package com.aosica.openapi.controller;


import com.aosica.common.bean.RequestResult;
import com.aosica.openapi.dto.OpenUser;
import com.aosica.openapi.service.OpenUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *  开放平台 用户管理 controller 管理模块
 */
@Controller
@RequestMapping("/open/api/user")
public class OpenUserController {


    @Autowired
    private OpenUserService openUserService ;


    /**
     *  创建 开放平台用户
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public RequestResult<OpenUser> createOpenUser() {
        OpenUser openUser = null;
        try {
            openUser = this.openUserService.createOpenUser();
            return RequestResult.buildOkData(openUser) ;
        }
        catch (Exception e) {
            e.printStackTrace();
            return RequestResult.buildFail() ;
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public RequestResult list() {
//        OpenUser openUser = null;
//        try {
//            openUser = this.openUserService.createOpenUser();
            return RequestResult.buildOK() ;
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return RequestResult.buildFail() ;
//        }
    }




}
