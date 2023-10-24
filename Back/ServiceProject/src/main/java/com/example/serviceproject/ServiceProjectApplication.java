package com.example.serviceproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProjectApplication.class, args);
    }

}
