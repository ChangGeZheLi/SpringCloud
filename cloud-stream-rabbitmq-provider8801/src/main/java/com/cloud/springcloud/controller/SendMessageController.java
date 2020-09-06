package com.cloud.springcloud.controller;

import com.cloud.springcloud.service.impl.MessageProviderImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 */
@RestController
@Slf4j
public class SendMessageController {

    @Resource
    private MessageProviderImpl messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
