package com.cloud.cloudapicommons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class CloudApiCommonsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudApiCommonsApplication.class, args);
    }

}
