package com.cloud.springcloud;

import com.cloud.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Description: 启动类
 */
@SpringBootApplication
@EnableEurekaClient
//本服务访问CLOUD-PAYMENT-SERVICE微服务，通过自定义的MyselfRule中的模式进行访问
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyselfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
