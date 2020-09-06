package com.cloud.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: 启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaProviderMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaProviderMain9002.class,args);
    }
}
