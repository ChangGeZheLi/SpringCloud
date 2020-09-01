package com.cloud.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Description: 配置openFeign日志
 */
@Configuration
public class OpenFeignConfig {

    /**
     * 配置openfeign日志级别为FULL
     **/
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
