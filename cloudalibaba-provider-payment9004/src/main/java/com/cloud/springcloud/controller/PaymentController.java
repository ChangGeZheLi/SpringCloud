package com.cloud.springcloud.controller;

import com.cloud.cloudapicommons.entities.CommonResult;
import com.cloud.cloudapicommons.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static Map<Long, Payment> map = new HashMap<>();
    static {
        map.put(1L,new Payment(1L,"001"));
        map.put(2L,new Payment(2L,"002"));
        map.put(3L,new Payment(3L,"003"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = map.get(id);
        return new CommonResult<>(200,"from mysql,serverPort:  " + serverPort,payment);
    }
}
