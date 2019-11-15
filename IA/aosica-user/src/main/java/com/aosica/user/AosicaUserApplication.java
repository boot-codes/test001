package com.aosica.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@EnableResourceClients(basePackages = "com.aosica.user.controller")
@SpringBootApplication
public class AosicaUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(AosicaUserApplication.class, args);
    }

}
