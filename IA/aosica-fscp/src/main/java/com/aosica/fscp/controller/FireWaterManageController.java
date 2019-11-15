package com.aosica.fscp.controller;

import com.aoscia.base.dto.FireWaterDto;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.fscp.api.FireWaterManageService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @program: ai-planting->FireWaterManageController
 * @description: 消防水源信息管理
 * @author: ll
 * @create: 2019-11-04 16:30
 **/

@Api(tags = "消防水源管理 api")
@RequestMapping("/fireWaterManage")
@RestController
public class FireWaterManageController implements ManageControllerApi<FireWaterDto>{


    @Autowired
    private FireWaterManageService fireWaterManageService;



    @Override
    public RequestResultPage<Page<FireWaterDto>> selectList(@Valid FireWaterDto dto, BindingResult bindingResult) {


        System.out.println("------------进入FireWaterManageController-------1--------");
        System.out.println("dto:"+dto);
        if(bindingResult.hasErrors()) {
            System.out.println("页面参数有误");
            return  RequestResultPage.build(500 , bindingResult.getFieldError().getDefaultMessage()) ;
        }
        return  this.fireWaterManageService.selectList(dto) ;
    }
    @Override
    public RequestResult selectDetailById(String id) {
        System.out.println("id:"+id);
        return fireWaterManageService.selectDetailById(id);
    }


    @Override
    public RequestResult saveAndUpdate(@Valid FireWaterDto dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println("页面参数有误");

            return  RequestResult.build(500 , bindingResult.getFieldError().getDefaultMessage()) ;
        }
        return  this.fireWaterManageService.saveAndUpdate(dto);
    }

    @Override
    public RequestResult remove(String id) {
        return fireWaterManageService.remove(id);
    }
}
