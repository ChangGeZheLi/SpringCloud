package com.cloud.springcloud.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description:
 */
@Service
public interface PaymentService {

    /**
     * 可以正常访问的方法，肯定ok
     * @Param [id]
     **/
    public String paymentInfo_ok(Integer id);

    /**
     * 制造异常
     * @Param [id]
     **/
    public String paymentInfo_Timeout(Integer id);

    /**
     * 服务熔断测试
     **/
    public String paymentCircuitBreaker(@PathVariable("id") Integer id);
}
