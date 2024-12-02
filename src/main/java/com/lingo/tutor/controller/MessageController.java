package com.lingo.tutor.controller;


import com.lingo.tutor.model.UserMessage;
import com.lingo.tutor.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {


    @Autowired
    private MessageService messageService;


    @PostMapping
    public void sendMessage(@RequestBody UserMessage userMessage) {
        messageService.sendMessage(userMessage);
    }


}
