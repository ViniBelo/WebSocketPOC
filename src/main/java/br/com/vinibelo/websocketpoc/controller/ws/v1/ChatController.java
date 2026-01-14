package br.com.vinibelo.websocketpoc.controller.ws.v1;

import br.com.vinibelo.websocketpoc.entity.Chat;
import br.com.vinibelo.websocketpoc.model.UserMessage;
import br.com.vinibelo.websocketpoc.service.ChatsService;
import br.com.vinibelo.websocketpoc.service.MessagesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@AllArgsConstructor
public class ChatController {
    private ChatsService chatsService;
    private MessagesService messagesService;

    @MessageMapping("/chat/{chatId}")
    @SendTo("/topic/chat/{chatId}")
    public UserMessage sendMessage (@DestinationVariable UUID chatId,
                                    @Payload @Valid UserMessage message) throws ChangeSetPersister.NotFoundException {
        Chat chat = chatsService.findById(chatId);
        System.out.println(message);
        messagesService.saveMessage(message.getContent(), chat);
        return message;
    }
}
