package com.cloud.springcloud.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Description:
 */
public interface MessageConsumer {
    String IN_PUT = "input";

    @Input(IN_PUT)
    SubscribableChannel input();
}
