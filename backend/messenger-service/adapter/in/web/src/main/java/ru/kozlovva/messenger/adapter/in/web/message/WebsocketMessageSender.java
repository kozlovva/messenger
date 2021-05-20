package ru.kozlovva.messenger.adapter.in.web.message;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import ru.kozlovva.messenger.core.domain.message.entity.Message;
import ru.kozlovva.messenger.core.domain.message.port.MessageSender;

@RequiredArgsConstructor
@Component
public class WebsocketMessageSender implements MessageSender {

    private final static String QUEUE = "/queue/messages";
    private final SimpMessagingTemplate simpMessagingTemplate;

    @Override
    public void send(Message message) {
        message.getRoom().getMembers()
                .forEach(u -> {
                    simpMessagingTemplate.convertAndSendToUser(
                            u.getId(),
                            QUEUE,
                            ru.kozlovva.messenger.adapter.in.web.message.Message.from(message)
                    );
                });
    }
}
