package com.cloud.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 */
@RestController
@Slf4j
//添加该注解，赋予刷新功能
@RefreshScope
public class ConfigClientController {

    /**
     * 读取到远程配置文件中config.info内容
     * 重启之后想要能够动态刷新配置文件，需要给actuator发送一次post请求
     * curl -X POST "http://localhost:3355/actuator/refresh"
     **/
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }

}
