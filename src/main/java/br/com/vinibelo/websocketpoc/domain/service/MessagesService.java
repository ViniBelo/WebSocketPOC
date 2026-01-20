package br.com.vinibelo.websocketpoc.domain.service;

import br.com.vinibelo.websocketpoc.persistence.entity.Chat;
import br.com.vinibelo.websocketpoc.persistence.entity.Message;
import br.com.vinibelo.websocketpoc.persistence.repository.MessagesRepository;
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
