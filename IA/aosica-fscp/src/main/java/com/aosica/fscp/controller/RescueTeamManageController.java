package com.aosica.fscp.controller;

import com.aoscia.base.dto.FireWaterDto;
import com.aoscia.base.dto.RescueTeamDto;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.fscp.api.RescueTeamManageService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @program: ai-planting->RescueTeamManageController
 * @description: 救援队伍信息管理
 * @author: ll
 * @create: 2019-11-01 19:14
 **/

@Api(tags = "救援队伍管理 api")
@RequestMapping("rescueTeamManage")
@RestController
public class RescueTeamManageController implements ManageControllerApi<RescueTeamDto>{
    
    @Autowired
    private RescueTeamManageService rescueTeamManageService;

    @Override
    public RequestResultPage<Page<RescueTeamDto>> selectList(@Valid RescueTeamDto dto, BindingResult bindingResult) {


        System.out.println("------------进入FireWaterManageController-------1--------");
        System.out.println("dto:"+dto);
        if(bindingResult.hasErrors()) {
            System.out.println("页面参数有误");
            return  RequestResultPage.build(500 , bindingResult.getFieldError().getDefaultMessage()) ;
        }
        return  this.rescueTeamManageService.selectList(dto) ;
    }
    @Override
    public RequestResult selectDetailById(String id) {
        System.out.println("id:"+id);
        return rescueTeamManageService.selectDetailById(id);
    }


    @Override
    public RequestResult saveAndUpdate(@Valid RescueTeamDto dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println("页面参数有误");

            return  RequestResult.build(500 , bindingResult.getFieldError().getDefaultMessage()) ;
        }
        return  this.rescueTeamManageService.saveAndUpdate(dto);
    }



    @Override
    public RequestResult remove(String id) {
        return rescueTeamManageService.remove(id);
    }
}