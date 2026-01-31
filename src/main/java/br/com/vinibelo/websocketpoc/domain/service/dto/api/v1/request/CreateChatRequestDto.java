package br.com.vinibelo.websocketpoc.domain.service.dto.api.v1.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record CreateChatRequestDto(
        @NotBlank(message = "The name cannot be empty.")
        @Size(min = 4, max = 255, message = "The name needs to be between 4 and 255 characters.")
        String name) { }
