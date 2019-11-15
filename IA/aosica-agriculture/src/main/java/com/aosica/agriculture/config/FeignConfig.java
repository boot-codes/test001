package com.aosica.agriculture.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * feign 增加重试功能。
 */
//@Configuration
public class FeignConfig {

    @Bean
    public Retryer feignRetryer () {
        return new Retryer.Default(100L, 1L , 3)  ;
  }  
}