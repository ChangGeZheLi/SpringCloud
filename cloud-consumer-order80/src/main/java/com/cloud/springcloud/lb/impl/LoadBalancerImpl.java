package com.cloud.springcloud.lb.impl;

import com.cloud.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 手动实现Ribbon轮询算法
 */
@Component
public class LoadBalancerImpl implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 使用自旋锁+CAS得到服务列表下标
     **/
    public final int getAndIncrement(){
        int current;
        int next;

        do {
            current = this.atomicInteger.get();
            //2147483647为整型的最大值
            //Ribbon中，如果服务不重启，会一直使用当前访问次数进行取余，为了保证不会溢出
            next = current >= 2147483647 ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*****第几次访问，次数next: " + next);
        return next;
    }

    /**
     * 负载均衡算法：rest接口第几次访问 % 服务器集群中枢 = 实际调用服务器位置下标
     * 每次服务重启后rest接口计数从1开始
     **/
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        //通过getAndIncrement得到当前访问次数，同服务实例总数取余，得到真正访问的服务下标
        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
