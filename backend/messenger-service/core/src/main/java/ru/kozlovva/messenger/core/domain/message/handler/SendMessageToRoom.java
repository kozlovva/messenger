package ru.kozlovva.messenger.core.domain.message.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.kozlovva.messenger.core.common.EventDispatcher;
import ru.kozlovva.messenger.core.domain.message.event.out.MessageCreatedEvent;
import ru.kozlovva.messenger.core.domain.message.port.MessageSender;

@Slf4j
@RequiredArgsConstructor
public class SendMessageToRoom implements EventDispatcher.EventHandler<MessageCreatedEvent> {

    private final MessageSender messageSender;

    @Override
    public void onEvent(MessageCreatedEvent event) {
        messageSender.send(event.getMessage());
        log.debug("Sending message to room \n{}", event.getMessage().toString());
    }
}
