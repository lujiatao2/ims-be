package com.lujiatao.ims.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.lujiatao.ims.api")
public class Web {

    public static void main(String[] args) {
        SpringApplication.run(Web.class, args);
    }

}
