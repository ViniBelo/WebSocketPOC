package br.com.vinibelo.websocketpoc;

import br.com.vinibelo.websocketpoc.model.UserMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public UserMessage sendMessage (@Payload UserMessage message) {
        System.out.println(message.getMessage());
        return message;
    }
}
