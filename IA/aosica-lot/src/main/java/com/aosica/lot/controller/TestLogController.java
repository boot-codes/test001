package com.aosica.lot.controller;


import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.lot.api.FireFightingDeviceServiceApi;
import com.aosica.lot.dto.DeviceSystemTypeDto;
import com.aosica.lot.dto.FireFightingDeviceQueryDto;
import com.aosica.lot.service.FireFightingDeviceService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lot")
public class TestLogController {

    @Autowired
    private FireFightingDeviceService fireFightingDeviceService ;

    @Autowired
    FireFightingDeviceServiceApi fireFightingDeviceServiceApi ;

    @RequestMapping("/test01")
    @ResponseBody
    public RequestResultPage<Page<DeviceSystemTypeDto>> getLotPage() {

        FireFightingDeviceQueryDto deviceQueryDto = new FireFightingDeviceQueryDto() ;
        deviceQueryDto.setProjectId("1000");
        deviceQueryDto.setPageSize(5);
        deviceQueryDto.setPageNum(0);
        deviceQueryDto.setSystemType("火灾自动报警系统");
        //Page<DeviceSystemTypeDto> page = this.fireFightingDeviceService.getListByCondition(deviceQueryDto);

//        Page<DeviceSystemTypeDto> page = fireFightingDeviceServiceApi.getList(deviceQueryDto);
//        System.out.println(page);
//
//        System.out.println(page.getTotal());
//        System.out.println(page.getPages());



//        return RequestResultPage.buildOK(page) ;
        return  null ;
    }



}
