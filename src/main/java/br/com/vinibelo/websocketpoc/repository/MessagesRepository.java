package br.com.vinibelo.websocketpoc.repository;

import br.com.vinibelo.websocketpoc.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MessagesRepository extends JpaRepository<Message, UUID> { }
