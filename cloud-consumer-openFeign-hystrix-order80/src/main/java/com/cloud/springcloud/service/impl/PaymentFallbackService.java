package com.cloud.springcloud.service.impl;

import com.cloud.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @Description:
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "****PaymentFallbackService fallback -paymentInfo_ok";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "****PaymentFallbackService fallback -paymentInfo_timeout";
    }
}
