package com.cloud.springcloud.service;

import com.cloud.cloudapicommons.entities.CommonResult;
import com.cloud.cloudapicommons.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description: 使用feign进行服务调用接口
 */
@Component
//value中是对外暴露的微服务名称
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    /**
     * 对应provider8001的service的getPaymentById方法
     * @Param [id]
     **/
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
