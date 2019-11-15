package com.aosica.fscp.controller;

import com.aoscia.base.dto.FireWaterDto;
import com.aoscia.base.dto.LawEnforcementTeamDto;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.fscp.api.LawEnforcementTeamManageService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @program: ai-planting->LawEnforcementTeam
 * @description: 执法队伍信息管理
 * @author: ll
 * @create: 2019-11-01 19:22
 **/
@Api(tags = "执法队伍管理 api")
@RequestMapping("lawEnforcementTeamManage")
@RestController
public class LawEnforcementTeamManageController implements ManageControllerApi<LawEnforcementTeamDto>{

    @Autowired
    private LawEnforcementTeamManageService lawEnforcementTeamManageService;

    @Override
    public RequestResultPage<Page<LawEnforcementTeamDto>> selectList(@Valid LawEnforcementTeamDto dto, BindingResult bindingResult) {
        System.out.println("------------进入FireWaterManageController-------1--------");
        System.out.println("dto:"+dto);
        if(bindingResult.hasErrors()) {
            System.out.println("页面参数有误");
            return  RequestResultPage.build(500 , bindingResult.getFieldError().getDefaultMessage()) ;
        }
        return  this.lawEnforcementTeamManageService.selectList(dto) ;
    }
    @Override
    public RequestResult selectDetailById(String id) {
        System.out.println("id:"+id);
        return lawEnforcementTeamManageService.selectDetailById(id);
    }


    @Override
    public RequestResult saveAndUpdate(@Valid LawEnforcementTeamDto dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println("页面参数有误");

            return  RequestResult.build(500 , bindingResult.getFieldError().getDefaultMessage()) ;
        }
        return  this.lawEnforcementTeamManageService.saveAndUpdate(dto);
    }

    @Override
    public RequestResult remove(String id) {
        return lawEnforcementTeamManageService.remove(id);
    }
    
}
