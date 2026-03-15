package com.sts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.service.MessageProducer;

@RestController
public class TestController {

    @Autowired
    MessageProducer producer;

    @GetMapping("/send")
    public String send() {

        producer.sendMessage("Hello RabbitMQ");

        return "Message Sent";
    }
}