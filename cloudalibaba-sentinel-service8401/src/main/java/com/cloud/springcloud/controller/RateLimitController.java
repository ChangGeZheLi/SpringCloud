package com.cloud.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.cloudapicommons.entities.CommonResult;
import com.cloud.cloudapicommons.entities.Payment;
import com.cloud.springcloud.myhandler.CustomBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:SentinelResource
 */
@RestController
@Slf4j
public class RateLimitController {

    /**
     * 根据资源名限流
     **/
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试ok",new Payment(2020L,"serial001"));
    }
    public CommonResult handleException(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用！！！");
    }

    /**
     * 根据url限流,使用自定义处理方法进行fallback
     **/
    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl",blockHandlerClass = CustomBlockHandler.class,blockHandler = "handlerException")
    public CommonResult byURL(){
        return new CommonResult(200,"按资源名称限流测试ok",new Payment(2020L,"serial002"));
    }
}

