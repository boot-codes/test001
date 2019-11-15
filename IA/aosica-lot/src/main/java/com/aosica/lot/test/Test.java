package com.aosica.lot.test;

import com.aosica.lot.dto.DeviceSystemTypeDto;
/**
 * @PackgeName com.aosica.lot.test
 * @ClassName Test.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/15 15:36
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/15$ 15:36$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

//        String topicName = "stds/up/CL/866262045467163" ;
//        topicName.lastIndexOf("/") ;
//        String[] arrays = topicName.split("stds/up/CL/");
//        System.out.println(arrays[1]);
//        System.out.println();


        DeviceSystemTypeDto deviceSystemTypeDto = new DeviceSystemTypeDto() ;

        deviceSystemTypeDto.setId(1111L);
        deviceSystemTypeDto.setDeviceId("456854155588554");
        deviceSystemTypeDto.setBuildingName("深圳市宝安区金宝大厦");
        deviceSystemTypeDto.setDeviceType("火灾自动报警系统");

    }







}
