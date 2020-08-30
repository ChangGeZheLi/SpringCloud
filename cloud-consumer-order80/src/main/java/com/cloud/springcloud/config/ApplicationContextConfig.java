package com.cloud.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: bean配置类
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 将restTemplate交给spring容器管理
     * 使用LoadBalanced赋予restTemplate负载均衡权力
     * @Param []
     **/
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
