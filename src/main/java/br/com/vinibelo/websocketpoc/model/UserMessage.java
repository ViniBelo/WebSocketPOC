package br.com.vinibelo.websocketpoc.model;

import lombok.Getter;

@Getter
public class UserMessage {
    private String content;
    private String senderId;

    public UserMessage() { }

    @Override
    public String toString() {
        return "UserMessage [body=" + content + ", senderId=" + senderId + "]";
    }
}
