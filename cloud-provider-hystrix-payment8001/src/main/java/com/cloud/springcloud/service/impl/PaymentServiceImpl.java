package com.cloud.springcloud.service.impl;

import com.cloud.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 */
@Component
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfo_ok(Integer id) {
        return "线程池：  " + Thread.currentThread().getName() + "  paymentInfo_ok,id:  " + "\t" + "hhhhh";
    }

    @Override
    //指定该方法出问题时，服务降级的fallback处理方法,无论是超时还是运行异常都会进入到paymentInfo_TimeOutHandler方法中
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            //规定timeoutInMilliseconds线程超时时间为3s，3s以内正常
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_Timeout(Integer id) {

        int timeNumber = 5;
        //让进程睡眠三秒，产生异常
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池：  " + Thread.currentThread().getName() + "  paymentInfo_ok,id:  " + "\t" + "耗时：  " + timeNumber;
    }

    /**
     * 服务降级处理方法
     * paymentInfo_Timeout出现异常时，进入该处理方法
     **/
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池：  " + Thread.currentThread().getName() + "  系统繁忙，请稍后再试，id： " + id;
    }

    /**
     * 测试Hystrix服务熔断机制
     **/
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") //失败率到达value后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能为负数");
        }

        UUID uuid = UUID.randomUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号： " + uuid.toString();
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请重新输入，id：  " + id;
    }
}
