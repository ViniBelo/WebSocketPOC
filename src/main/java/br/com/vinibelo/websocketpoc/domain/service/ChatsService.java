package br.com.vinibelo.websocketpoc.domain.service;

import br.com.vinibelo.websocketpoc.domain.service.dto.api.v1.response.ChatsToListResponseDto;
import br.com.vinibelo.websocketpoc.domain.service.dto.api.v1.response.CreateChatResponseDto;
import br.com.vinibelo.websocketpoc.domain.service.dto.api.v1.response.ListChatsResponseDto;
import br.com.vinibelo.websocketpoc.persistence.entity.Chat;
import br.com.vinibelo.websocketpoc.persistence.repository.ChatsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public ListChatsResponseDto listChats(int perPage, int page) {
        Pageable pageable = PageRequest.of(page, perPage);
        Page<Chat> pageableChats = chatsRepository.findAll(pageable);
        ArrayList<ChatsToListResponseDto> chatsToList = new ArrayList<>(
                pageableChats.stream()
                .map(chat -> {
                    return new ChatsToListResponseDto(chat.getId(), chat.getName());
                }).toList());
        return new ListChatsResponseDto(
                chatsToList,
                pageableChats.getTotalElements(),
                pageableChats.getTotalPages(),
                perPage,
                page
        );
    }
}
