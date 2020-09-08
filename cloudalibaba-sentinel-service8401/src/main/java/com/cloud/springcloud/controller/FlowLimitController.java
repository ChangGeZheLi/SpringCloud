package com.cloud.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "*************TestA";
    }

    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName()+"\t ... testB");
        return "*************TestB";
    }

    @GetMapping("/testD")
    public String testD(){
        //测试熔断限流的RT
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        log.info("******testD");

        //测试熔断限流的异常比例
//        int age = 10/0;
        return "******testD";
    }

    //测试规则
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_HotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "------testHotKey";
    }

    //fallback方法
    public String deal_HotKey(String p1, String p2, BlockException exception){
        return "--------deal_HotKey";
    }
}
