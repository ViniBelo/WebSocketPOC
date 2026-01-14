package br.com.vinibelo.websocketpoc.service;

import br.com.vinibelo.websocketpoc.entity.Chat;
import br.com.vinibelo.websocketpoc.entity.Message;
import br.com.vinibelo.websocketpoc.repository.MessagesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessagesService {
    private final MessagesRepository messagesRepository;

    public void saveMessage(String content, Chat chat) {
        messagesRepository.save(new Message(content, chat));
    }
}
