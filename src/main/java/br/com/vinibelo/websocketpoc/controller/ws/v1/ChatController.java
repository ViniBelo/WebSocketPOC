package br.com.vinibelo.websocketpoc.controller.ws.v1;

import br.com.vinibelo.websocketpoc.model.UserMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/chat/{roomId}")
    public UserMessage sendMessage (@DestinationVariable String roomId, @Payload UserMessage message) {
        System.out.println("Message to room: " + roomId + " " + message);
        return message;
    }
}
