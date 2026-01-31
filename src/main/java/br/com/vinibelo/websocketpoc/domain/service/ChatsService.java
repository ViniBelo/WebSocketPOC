package br.com.vinibelo.websocketpoc.domain.service;

import br.com.vinibelo.websocketpoc.domain.service.dto.api.v1.response.CreateChatResponseDto;
import br.com.vinibelo.websocketpoc.domain.service.dto.api.v1.response.ListChatsResponseDto;
import br.com.vinibelo.websocketpoc.persistence.entity.Chat;
import br.com.vinibelo.websocketpoc.persistence.repository.ChatsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ChatsService {
    private final ChatsRepository chatsRepository;

    public CreateChatResponseDto createChat(String name) {
        Chat chat = new Chat(name);
        chatsRepository.save(chat);
        return new CreateChatResponseDto(chat.getId(), chat.getName());
    }

    public Chat findById(UUID id) throws ChangeSetPersister.NotFoundException {
        return chatsRepository
                .findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public List<ListChatsResponseDto> listChats() {
        List<Chat> chats = chatsRepository.findAll();
        return new ArrayList<>(
                chats.stream()
                .map(chat -> {
                    return new ListChatsResponseDto(chat.getId(), chat.getName());
                }).toList());
    }
}
