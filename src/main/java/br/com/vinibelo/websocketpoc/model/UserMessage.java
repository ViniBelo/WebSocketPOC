package br.com.vinibelo.websocketpoc.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

import java.time.Instant;

@Data
@Getter
public class UserMessage {
    @NotBlank
    @Size(max = 255)
    private String content;
    private String senderId;
    private Instant createdAt;

    public UserMessage() { }

    @Override
    public String toString() {
        return "UserMessage [body=" + content + ", senderId=" + senderId + "]";
    }
}
