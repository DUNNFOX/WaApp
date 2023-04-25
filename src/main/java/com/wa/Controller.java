package com.wa;


import com.wa.model.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @GetMapping("/health")
    String testEndpoint(){
        messagingTemplate.convertAndSend("/topic/greetings", new HelloMessage("Health api called"));
        return "ok..";
    }
}