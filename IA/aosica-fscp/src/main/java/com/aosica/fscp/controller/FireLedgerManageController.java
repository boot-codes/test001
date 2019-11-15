package com.aosica.fscp.controller;

import com.aoscia.base.dto.FireLedgerDto;
import com.aoscia.base.dto.FireLedgerDto;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.fscp.api.FireLedgerManageService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @program: ai-planting->fireLedgermanageController
 * @description: 消防台账信息管理
 * @author: ll
 * @create: 2019-11-01 19:21
 **/

@Api(tags = "消防台账管理 api")
@RequestMapping("/fireLedgerManage")
@RestController
public class FireLedgerManageController implements ManageControllerApi<FireLedgerDto>{


    @Autowired
    private FireLedgerManageService fireLedgerManageService;



    @Override
    public RequestResultPage<Page<FireLedgerDto>> selectList(@Valid FireLedgerDto dto, BindingResult bindingResult) {
        System.out.println("------------进入FireLedgerManageController-------1--------");
        System.out.println("dto:"+dto);
        if(bindingResult.hasErrors()) {
            System.out.println("页面参数有误");
            return  RequestResultPage.build(500 , bindingResult.getFieldError().getDefaultMessage()) ;
        }
        return  this.fireLedgerManageService.selectList(dto) ;
    }
    @Override
    public RequestResult selectDetailById(String id) {
        System.out.println("id:"+id);
        return fireLedgerManageService.selectDetailById(id);
    }

    @Override
    public RequestResult saveAndUpdate(@Valid FireLedgerDto dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println("页面参数有误");
            return  RequestResult.build(500 , bindingResult.getFieldError().getDefaultMessage()) ;
        }
        return  this.fireLedgerManageService.saveAndUpdate(dto);
    }

    @Override
    public RequestResult remove(String id) {
        return null;
    }



    /**
     * 根据品牌查询型号
     * @param brand
     * @return 操作结果
     */
    @RequestMapping(value = "/queryModelByBrand/{brand}", method = RequestMethod.GET)
    RequestResult queryModelByBrand(@PathVariable(value = "brand") String brand){

        return fireLedgerManageService.queryModelByBrand(brand);
    }



}

