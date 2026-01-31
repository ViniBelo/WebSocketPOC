package br.com.vinibelo.websocketpoc.api.v1.controller.chats;

import br.com.vinibelo.websocketpoc.domain.service.dto.api.v1.request.CreateChatRequestDto;
import br.com.vinibelo.websocketpoc.domain.service.dto.api.v1.response.CreateChatResponseDto;
import br.com.vinibelo.websocketpoc.domain.service.dto.api.v1.response.ListChatsResponseDto;
import br.com.vinibelo.websocketpoc.domain.service.ChatsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController()
@RequestMapping("api/v1/chats")
@AllArgsConstructor
public class ChatsController {
    private final ChatsService chatsService;

    /**
     * Creates chat; returns URI to created resource
     */
    @PostMapping()
    public ResponseEntity<CreateChatResponseDto> createChat(@RequestBody @Valid CreateChatRequestDto createChatRequestDto) {
        CreateChatResponseDto chatReponse = chatsService.createChat(createChatRequestDto.name());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(chatReponse.id())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(chatReponse);
    }

    @GetMapping()
    public ResponseEntity<List<ListChatsResponseDto>> listChats() {
        return ResponseEntity.ok(
                chatsService.listChats()
        );
    }
}
