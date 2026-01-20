package br.com.vinibelo.websocketpoc.api.v1.controller.chats;

import br.com.vinibelo.websocketpoc.domain.service.dto.api.v1.CreateChatRequestDto;
import br.com.vinibelo.websocketpoc.domain.service.dto.api.v1.ListChatsResponseDto;
import br.com.vinibelo.websocketpoc.domain.service.ChatsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/v1/chats")
@AllArgsConstructor
public class ChatsController {
    private final ChatsService chatsService;

    @PostMapping()
    public void createChat(@RequestBody CreateChatRequestDto createChatRequestDto) {
        chatsService.createChat(createChatRequestDto.name());
    }

    @GetMapping()
    public ResponseEntity<List<ListChatsResponseDto>> listChats() {
        return ResponseEntity.ok(
                chatsService.listChats()
        );
    }
}
