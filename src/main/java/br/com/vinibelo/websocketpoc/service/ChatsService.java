package br.com.vinibelo.websocketpoc.service;

import br.com.vinibelo.websocketpoc.entity.Chat;
import br.com.vinibelo.websocketpoc.repository.ChatsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ChatsService {
    private final ChatsRepository chatsRepository;

    public void createChat(String name) {
        Chat chat = new Chat(name);
        chatsRepository.save(chat);
    }

    public Chat findById(UUID id) throws ChangeSetPersister.NotFoundException {
        return chatsRepository
                .findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
