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
@CrossOrigin("*")
public class ChatsController {
    private final ChatsService chatsService;

    /**
     * Creates a chat;
     * @param createChatRequestDto requires name (min = 4, max = 255)
     * @return ResponseEntity<CreateChatResponseDto>
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

    /**
     * Lists chats;
     * @param perPage chats per page
     * @param page current page
     * @return ResponseEntity<ListChatsResponseDto>
     */
    @GetMapping()
    public ResponseEntity<ListChatsResponseDto> listChats(
            @RequestParam(name = "perPage", required = false, defaultValue = "10") Integer perPage,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        return ResponseEntity.ok(chatsService.listChats(perPage, page));
    }
}
