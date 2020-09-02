package com.cloud.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

/**
 * @Description: 启动类
 */
@SpringBootApplication
//Hystrix图形化监控开启
@EnableHystrixDashboard
public class ConsumerHystrixMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixMain9001.class,args);
    }


}
