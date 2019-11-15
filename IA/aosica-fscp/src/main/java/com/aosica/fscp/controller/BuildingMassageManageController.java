package com.aosica.fscp.controller;

import com.aoscia.base.dto.BuildingDto;
import com.aoscia.base.dto.BuildingSecurityMassageDto;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.fscp.service.BuildingMassageManageService;
import com.aosica.user.dto.BuildingResponsiblePersonDto;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @program: ai-planting -> BuildingManage
 * @description: 建筑物信息管理
 * @author: ll
 * @create: 2019-11-01 19:08
 **/

@Api(tags = "建筑物管理 api")
@RequestMapping("buildingManage")
@RestController
public class BuildingMassageManageController {


    @Autowired
    private BuildingMassageManageService buildingMassageManageService;






    @RequestMapping(value = "selectList", method = RequestMethod.POST)
    public RequestResultPage<Page<BuildingDto>> selectList(@RequestBody @Valid BuildingDto dto, BindingResult bindingResult) {
        System.out.println("------------进入FireWaterManageController-------1--------");
        System.out.println("dto:"+dto);
        if(bindingResult.hasErrors()) {
            System.out.println("页面参数有误");
            return  RequestResultPage.build(500 , bindingResult.getFieldError().getDefaultMessage()) ;
        }
        return  this.buildingMassageManageService.selectList(dto) ;
    }




    @RequestMapping(value = "/selectDetailById/{id}", method = RequestMethod.GET)
    public RequestResult selectDetailById(@PathVariable("id") String id) {
        System.out.println("id:"+id);
        return buildingMassageManageService.selectDetailById(id);
    }




    @RequestMapping(value = "/selectDetailToManageMassageById/{id}", method = RequestMethod.GET)
    public RequestResult selectDetailToManageMassageById(@PathVariable("id") String id) {
        return buildingMassageManageService.selectDetailToManageMassageById(id);
    }



    @RequestMapping(value = "/selectDetailToFireSafeMassageById/{id}", method = RequestMethod.GET)
    public RequestResult selectDetailToFireSafeMassageById(@PathVariable("id") String id) {
        return buildingMassageManageService.selectDetailToFireSafeMassageById(id);
    }



    @RequestMapping(value = "updateDetail", method = RequestMethod.POST)
    public RequestResult updateDetail(@RequestBody @Valid BuildingDto dto, BindingResult bindingResult) {
       // public RequestResult saveAndUpdate(@Valid FireWaterDto dto, BindingResult bindingResult) {
            if(bindingResult.hasErrors()) {
                System.out.println("页面参数有误");

                return  RequestResult.build(500 , bindingResult.getFieldError().getDefaultMessage()) ;
            }
            return  this.buildingMassageManageService.updateDetail(dto);
        }



    @RequestMapping(value = "updateDetailToManageMassage/{id}", method = RequestMethod.POST)
    public RequestResult updateDetailToManageMassage(@RequestBody @Valid List<BuildingResponsiblePersonDto> dtos, BindingResult bindingResult,@PathVariable("id") String id) {
        System.out.println("进入updateDetailToManageMassage");
        System.out.println(dtos);
        if(bindingResult.hasErrors()) {
            System.out.println("页面参数有误");
            return  RequestResult.build(500 , bindingResult.getFieldError().getDefaultMessage()) ;
        }
        return  this.buildingMassageManageService.updateDetailToManageMassage(dtos,id);
    }


    @RequestMapping(value = "updateDetailToFireSafeMassage", method = RequestMethod.POST)
    public RequestResult updateDetailToFireSafeMassage(@RequestBody @Valid BuildingSecurityMassageDto dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println("页面参数有误");
            return  RequestResult.build(500 , bindingResult.getFieldError().getDefaultMessage()) ;
        }
        return  this.buildingMassageManageService.updateDetailToFireSafeMassage(dto);
    }



    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public RequestResult insert(@RequestBody @Valid BuildingDto dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println("页面参数有误");
            return  RequestResult.build(500 , bindingResult.getFieldError().getDefaultMessage()) ;
        }
        return  this.buildingMassageManageService.insert(dto);
    }



    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public RequestResult remove(@PathVariable("id") String id) {
        return buildingMassageManageService.remove(id);
    }


    @RequestMapping(value = "/queryBuildIdAndNameListByFuzzyName/{fuzzyName}", method = RequestMethod.GET)
    public RequestResult queryBuildIdAndNameListByFuzzyName(@PathVariable("fuzzyName") String fuzzyName) {
        return buildingMassageManageService.queryBuildIdAndNameListByFuzzyName(fuzzyName);
    }


    @RequestMapping(value = "/queryFloorById/{id}", method = RequestMethod.GET)
    public RequestResult queryFloorById(@PathVariable("id") String id) {
        return buildingMassageManageService.queryFloorById(id);
    }



}