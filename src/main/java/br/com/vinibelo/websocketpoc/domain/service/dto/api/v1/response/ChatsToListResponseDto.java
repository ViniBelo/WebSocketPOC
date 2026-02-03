package br.com.vinibelo.websocketpoc.domain.service.dto.api.v1.response;

import java.util.UUID;

public record ChatsToListResponseDto(
        UUID id,
        String name
) { }
