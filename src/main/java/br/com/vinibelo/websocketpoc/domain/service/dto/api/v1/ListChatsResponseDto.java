package br.com.vinibelo.websocketpoc.domain.service.dto.api.v1;

import java.util.UUID;

public record ListChatsResponseDto(
        UUID id,
        String name
) { }
