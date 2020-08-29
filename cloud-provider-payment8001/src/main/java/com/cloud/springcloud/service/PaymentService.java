package com.cloud.springcloud.service;

import com.cloud.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: payment的service层
 */
public interface PaymentService {

    /**
     * 添加数据
     * @Param [payment]
     **/
    public int create(Payment payment);

    /**
     * 根据id查询数据
     * @Param [id]
     **/
    public Payment getPaymentById(@Param("id") Long id);
}
