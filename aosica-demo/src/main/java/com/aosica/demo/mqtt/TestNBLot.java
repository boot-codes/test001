package com.aosica.demo.mqtt;

/**
 * @PackgeName com.aosica.demo.mqtt
 * @ClassName TestNBLot.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/8/23 16:24
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/8/23$ 16:24$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public class TestNBLot {

    public static void main(String[] args) throws  Exception{

        String url = "https://develop.api.ct10649.com:8743/iocm/app/sec/v1.1.0/login" ;

        String s = HttpClientUtil.doPost(url);
        System.out.println(s);


    }
}
