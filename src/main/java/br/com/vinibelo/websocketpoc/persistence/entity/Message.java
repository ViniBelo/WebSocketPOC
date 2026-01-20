package br.com.vinibelo.websocketpoc.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "messages")
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    public Message(String message, Chat chat) {
        this.message = message;
        this.chat = chat;
    }
}
