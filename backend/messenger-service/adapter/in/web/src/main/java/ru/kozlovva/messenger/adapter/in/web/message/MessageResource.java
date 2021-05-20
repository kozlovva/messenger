package ru.kozlovva.messenger.adapter.in.web.message;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public interface MessageResource {

    @MessageMapping("/chat")
    void createMessage(@Payload CreateMessageRequest request);

}
