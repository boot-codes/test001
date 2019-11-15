package com.aosica.user.controller;


import com.aosica.common.bean.RequestResult;
import com.aosica.user.annotation.ResourceClient;
import com.aosica.user.dto.UserInfoDto;
import com.aosica.user.entity.User;
import com.aosica.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@Controller
public class UserController {

    @Autowired
    private UserService userService ;

    /**
     *
     */

    @ResourceClient("test")
    @RequestMapping(value = "/test01" ,method = RequestMethod.POST)
    @ResponseBody
    public RequestResult testCreateUser(@RequestBody @Valid UserInfoDto userInfoDto , BindingResult bindingResult) {

        System.out.println("registerDTO:=" +userInfoDto);
        if(bindingResult.hasErrors()){
            return  RequestResult.buildOkData(bindingResult.getFieldError().getDefaultMessage()) ;
        }

        try {
            User user = this.userService.createUser(userInfoDto);
            if(user != null ) {
                return RequestResult.buildOkData(user) ;
            }
            return RequestResult.buildFail() ;
        }
        catch (Exception e) {
            e.printStackTrace();
            return  RequestResult.buildFail() ;
        }


    }

}
