package br.com.vinibelo.websocketpoc.domain.service.dto.ws.v1;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

import java.time.Instant;

@Data
@Getter
public class ChatMessageDto {
    @NotBlank
    @Size(max = 255)
    private String content;
    private String senderId;
    private Instant createdAt;

    public ChatMessageDto() { }

    @Override
    public String toString() {
        return "UserMessage [body=" + content + ", senderId=" + senderId + "]";
    }
}
