package br.com.vinibelo.websocketpoc.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.UUID;

@Getter
@Entity(name = "chats")
public class Chat {
    @Id
    private UUID id;
    private String name;

    public Chat(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public Chat() { }
}
