package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryEurekaHAApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryEurekaHAApplication.class, args);
    }
}
