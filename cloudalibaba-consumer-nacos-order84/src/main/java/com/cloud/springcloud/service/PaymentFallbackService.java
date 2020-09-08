package com.cloud.springcloud.service;

import com.cloud.cloudapicommons.entities.CommonResult;
import com.cloud.cloudapicommons.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Description: PaymentService用来进行出错fallback的
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
