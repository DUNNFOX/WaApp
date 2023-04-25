package com.wa.restcontroller;

import com.wa.model.Greeting;
import com.wa.webhook.Messages;
import com.wa.webhook.Payload;
import com.wa.webhook.Statuses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @PostMapping("/webhooks")
    public Object handleIncomingMessages(@RequestBody Payload payload) {
        // todo
        // handle all the cases here for different types of webhook body
        System.out.println(payload.toString());
        String changedField = payload.getEntry().get(0).getChanges().get(0).getField();
        if (changedField.equals("messages")) {
            List<Messages> newMessage = payload.getEntry().get(0).getChanges().get(0).getValue().getMessages();
            if (!newMessage.isEmpty()) {// if not a new message then a status message
                String messageType = payload.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0)
                        .getType();
                switch (messageType) {
                    case ("text"): {
                        System.out.println("Message type is : text");
                String    message  = payload.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0).getText().getBody();
                        messagingTemplate.convertAndSend("/topic/greetings", new Greeting(message));
                        // take apt actions
                        return payload.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0);
                    }
                    case ("button"): {
                        System.out.println("Message type is : button");
                        // return message
                        break;
                    }
                    case ("document"): {
                        System.out.println("Message type is : document");
                        // return message
                        break;
                    }
                    case ("static/image"): {
                        System.out.println("Message type is : image");
                        break;
                    }
                    case ("interactive"): {
                        System.out.println("Message type is : interactive");
                        break;
                    }
                    case ("order"): {
                        System.out.println("Message type is : order");
                        break;
                    }
                    case ("sticker"): {
                        System.out.println("Message type is : sticker");
                        break;
                    }
                    case ("video"): {
                        System.out.println("Message type is : video");
                        break;
                    }
                    case ("system"): {
                        System.out.println("Message type is : system");
                        break;
                    }
                    case ("unknown"): {
                        System.out.println("Message type is : unknown");
                        break;
                    }
                    default: {
                        System.out.println("Message is not of any predefined types");
                        break;
                    }
                }
                return payload.getEntry().get(0).getChanges().get(0).getValue().getMessages().get(0);
            } else {
                Statuses statuses = payload.getEntry().get(0).getChanges().get(0).getValue().getStatuses().get(0);
                String status = statuses.getStatus();
                System.out.println("Message" + status);
                return payload.getEntry().get(0).getChanges().get(0).getValue().getStatuses().get(0);
            }
        }
        return "not a message type";
    }


    @GetMapping("/webhooks")
    public int verificationRequest(@RequestParam("hub.verify_token") String verifyToken,
                                   @RequestParam("hub.mode") String mode, @RequestParam("hub.challenge") String challenge) {
        if (verifyToken.equals("sandeep") && (mode.equals("subscribe")))
            return Integer.parseInt(challenge);
        return -1;
    }
}
