package com.cloud.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: 启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderMain8001.class,args);
    }
}
