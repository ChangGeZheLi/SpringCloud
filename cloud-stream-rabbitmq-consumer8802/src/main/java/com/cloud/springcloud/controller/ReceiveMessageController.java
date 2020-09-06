package com.cloud.springcloud.controller;

import com.cloud.springcloud.service.MessageConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description:
 */
@Component
@Slf4j
@EnableBinding(MessageConsumer.class)
public class ReceiveMessageController {


    @Value("${server.port}")
    private String serverPort;

    /**
     * 用StreamListener监控输入源
     **/
    @StreamListener(MessageConsumer.IN_PUT)
    public void input(Message<String> message){
        System.out.println("端口号： " + serverPort + "\t 收到的消息为： "  + message.getPayload());
    }

}
