package br.com.vinibelo.websocketpoc.persistence.repository;

import br.com.vinibelo.websocketpoc.persistence.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MessagesRepository extends JpaRepository<Message, UUID> { }
