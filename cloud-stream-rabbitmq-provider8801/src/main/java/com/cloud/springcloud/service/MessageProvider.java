package com.cloud.springcloud.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

/**
 * @Description:
 */
public interface MessageProvider {

    String OUT_PUT = "output";

    /**
     * 生产者发送消息
     **/
    @Output(OUT_PUT)
    MessageChannel output();
}
