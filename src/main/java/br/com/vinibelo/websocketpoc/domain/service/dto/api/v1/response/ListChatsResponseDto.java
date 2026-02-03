package br.com.vinibelo.websocketpoc.domain.service.dto.api.v1.response;

import java.util.List;

public record ListChatsResponseDto(
        List<ChatsToListResponseDto> chats,
        Long totalChats,
        int totalPages,
        int perPage,
        int page
) { }
