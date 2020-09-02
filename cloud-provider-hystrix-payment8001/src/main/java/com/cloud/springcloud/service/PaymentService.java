package com.cloud.springcloud.service;

import org.springframework.stereotype.Service;

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
}
