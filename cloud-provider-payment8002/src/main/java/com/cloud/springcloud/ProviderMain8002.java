package com.cloud.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: 启动类
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderMain8002.class,args);
    }
}
