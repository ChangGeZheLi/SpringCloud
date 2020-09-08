package com.cloud.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cloud.cloudapicommons.entities.CommonResult;
import com.cloud.cloudapicommons.entities.Payment;
import com.cloud.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description:
 */
@RestController
@Slf4j
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String SERVICE_URL;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback")
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult<Payment> payment = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id,CommonResult.class,id);
        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常。。。");
        }else if (payment.getData() == null){
                throw new NullPointerException("此ID没有对应数据，空指针异常");
        }
        return payment;
    }

    /////////////////////////OpenFeign
    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }
}
