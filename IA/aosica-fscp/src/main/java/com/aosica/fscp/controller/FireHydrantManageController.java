package com.aosica.fscp.controller;

import com.aoscia.base.dto.BuildingDto;
import com.aoscia.base.dto.FireHydrantDto;
import com.aoscia.base.dto.FireWaterDto;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.fscp.api.FireHydrantManageService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @program: ai-planting->FireHydrant
 * @description: 室外消防栓信息管理
 * @author: ll
 * @create: 2019-11-01 19:10
 **/
@Api(tags = "消防栓管理 api")
@RequestMapping("fireHydrantManage")
@RestController
public class FireHydrantManageController implements ManageControllerApi<FireHydrantDto>{

    @Autowired
    private FireHydrantManageService fireHydrantManageService;

    @Override
    public RequestResultPage<Page<FireHydrantDto>> selectList(@Valid FireHydrantDto dto, BindingResult bindingResult) {


        System.out.println("------------进入FireWaterManageController-------1--------");
        System.out.println("dto:"+dto);
        if(bindingResult.hasErrors()) {
            System.out.println("页面参数有误");
            return  RequestResultPage.build(500 , bindingResult.getFieldError().getDefaultMessage()) ;
        }
        return  this.fireHydrantManageService.selectList(dto) ;
    }


    @Override
    public RequestResult selectDetailById(String id) {
        System.out.println("id:"+id);
        return fireHydrantManageService.selectDetailById(id);
    }


    @Override
    public RequestResult saveAndUpdate(@Valid FireHydrantDto dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println("------------进入FireWaterManageController-------1--------");
            System.out.println("页面参数有误");

            return  RequestResult.build(500 , bindingResult.getFieldError().getDefaultMessage()) ;
        }
        return  this.fireHydrantManageService.saveAndUpdate(dto);
    }



    @Override
    public RequestResult remove(String id) {
        return fireHydrantManageService.remove(id);
    }

}


