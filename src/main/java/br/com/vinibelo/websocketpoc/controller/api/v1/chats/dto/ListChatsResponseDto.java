package br.com.vinibelo.websocketpoc.controller.api.v1.chats.dto;

import java.util.UUID;

public record ListChatsResponseDto(
        UUID id,
        String name
) { }
