package com.cloud.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Description: 手动实现Ribbon的轮询
 */
public interface LoadBalancer {

    /**
     * 定义返回值为Eureka服务实例的方法，用于收集当前服务总数，并保存到list中
     * @Param [serviceInstances]
     **/
    public ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
