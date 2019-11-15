package com.aosica.lot.test;
import com.aosica.common.config.IdWorker;
import com.aosica.common.constant.DeviceStateEnum;
import com.aosica.common.constant.DeviceSystemTypeEnum;
import com.aosica.common.exception.AosicaServiceSaveException;
import com.aosica.lot.dto.DeviceSystemTypeDto;
import com.aosica.lot.dto.FireFightingDeviceQueryDto;
import com.aosica.lot.entity.FireFightingDevice;
import com.aosica.lot.service.FireFightingDeviceService;
import com.github.pagehelper.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;

/**
 * @PackgeName com.aosica.lot.test
 * @ClassName LotDeviceTest.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/21 15:56
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/21$ 15:56$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class LotDeviceTest {

    @Autowired
    private FireFightingDeviceService fireFightingDeviceService ;


    String[] sytemType = {"火灾自动报警系统","独立烟感云传输系统","粉尘监测云传输系统","可燃气体云传输系统","电气火灾监控系统","室内水压监控系统"
            ,"室外水压监控系统","视频监控系统","应急监控云传输系统"} ;

    String[] deviceType = {"网关","控制器","传感器","采集器"};


    Random random_sytemType = new Random() ;

    Random random_deviceType = new Random() ;

    Random devid = new Random() ;

    Random random = new Random() ;

    /**
     *
     *
     */
    @Test
    public void testSave() throws AosicaServiceSaveException {

        for(int n=0 ;n<20000 ;n++) {

            FireFightingDevice fireFightingDevice = new FireFightingDevice();
            fireFightingDevice.setId(IdWorker.generateId());
            fireFightingDevice.setProjectId(1000l);
            //独立烟感云传输系统 火灾自动报警系统 ,粉尘监测云传输系统 , 可燃气体云传输系统
            fireFightingDevice.setSystemType(sytemType[random_sytemType.nextInt(8)]);
            fireFightingDevice.setDeviceType(deviceType[random_deviceType.nextInt(3)]);
            fireFightingDevice.setDeviceId(devid.nextInt(899999999)+100000000L);
            fireFightingDevice.setLongitude("112.4555852222");
            fireFightingDevice.setLatitude("95.4555852222");
            fireFightingDevice.setInstallLocation("深圳市南山区科技园"+random.nextInt(1000));
            fireFightingDevice.setBuildingId(324041514078044456L);
            fireFightingDevice.setInstallFloor(2);
            fireFightingDevice.setAssociatedUnitId(3240415140780411111L);
            fireFightingDevice.setSupervisionUnitId(3240415140780411111L);
            fireFightingDevice.setParentId(0L);
            fireFightingDevice.setCreateDate(new Date());
            fireFightingDevice.setCreater(0L);
            fireFightingDevice.setUpdateDate(new Date());
            fireFightingDevice.setUpdater(0L);
            //
            fireFightingDevice.setStatue(DeviceStateEnum.DEVICE_STATE_normal.getKey());

            this.fireFightingDeviceService.save(fireFightingDevice);
        }
    }


//    @Test
//    public void test01() {
//
//        FireFightingDeviceQueryDto deviceQueryDto = new FireFightingDeviceQueryDto() ;
//        deviceQueryDto.setProjectId("1000");
//        deviceQueryDto.setPageSize(5);
//        deviceQueryDto.setPageNum(0);
//        deviceQueryDto.setSystemType("火灾自动报警系统");
//        Page<DeviceSystemTypeDto> page = this.fireFightingDeviceService.getListByCondition(deviceQueryDto);
//        System.out.println(page);
//    }

}
