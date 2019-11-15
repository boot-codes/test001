package com.aoscia.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 基础启动类
 */

@EnableCircuitBreaker
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@MapperScan("com.aoscia.base.mapper")
public class AosicaBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(AosicaBaseApplication.class, args);
    }

}
