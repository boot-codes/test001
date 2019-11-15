package com.aosica.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 *
 * 功能描述: 服务注册中心
 *
 * @auther: yuzp
 * @date: 2019/8/14 18:47
 */
@EnableEurekaServer
@SpringBootApplication
public class AosicaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AosicaServerApplication.class, args);
    }

}
