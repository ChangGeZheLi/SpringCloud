package com.cloud.springcloud.controller.impl;

import com.cloud.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

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
}
