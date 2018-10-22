package com.jade.swpboot.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class StompController {
    @MessageMapping("/TTT")
    @SendTo("/topic/message")
    public String join(String message) throws InterruptedException {
    	Thread.sleep(3000);
        message += " 라고 메시지가 왔습니다.";
        System.out.println("MMMMMMMMMMMMMM>>" + message);
        return message;
    }

}
