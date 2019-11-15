package com.aosica.openapi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserLoginController {




    //@RequiresPermissions(value = )
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public void userLogin() {

        System.out.println("user login");
    }

}
