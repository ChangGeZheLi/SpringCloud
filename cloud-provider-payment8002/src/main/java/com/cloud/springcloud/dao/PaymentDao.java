package com.cloud.springcloud.dao;

import com.cloud.cloudapicommons.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: payment的dao层
 */
@Mapper
public interface PaymentDao {

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
