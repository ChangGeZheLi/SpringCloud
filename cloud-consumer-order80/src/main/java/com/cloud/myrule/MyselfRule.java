package com.cloud.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: Ribbon自定义负载均衡算法
 * 转换Ribbon负载均衡算法，不能在springboot @ComponentScan扫描的包下
 * 所以需要在springcloud包外边创建包
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule(){
        //定义负载均衡规则为随机
        return new RandomRule();
    }
}
