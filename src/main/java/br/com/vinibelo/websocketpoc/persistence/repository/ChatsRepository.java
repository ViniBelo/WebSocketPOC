package br.com.vinibelo.websocketpoc.persistence.repository;

import br.com.vinibelo.websocketpoc.persistence.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatsRepository extends JpaRepository<Chat, UUID> { }
