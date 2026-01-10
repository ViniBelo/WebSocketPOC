package br.com.vinibelo.websocketpoc.controller.api.v1.chats;

import br.com.vinibelo.websocketpoc.controller.api.v1.chats.dto.CreateChatRequestDto;
import br.com.vinibelo.websocketpoc.service.ChatsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/v1/chats")
@AllArgsConstructor
public class ChatsController {
    private final ChatsService chatsService;

    @PostMapping()
    public void createChat(@RequestBody CreateChatRequestDto createChatRequestDto) {
        chatsService.createChat(createChatRequestDto.name());
    }
}
