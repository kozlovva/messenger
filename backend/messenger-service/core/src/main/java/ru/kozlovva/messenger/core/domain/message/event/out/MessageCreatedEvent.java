package ru.kozlovva.messenger.core.domain.message.event.out;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.kozlovva.messenger.core.common.EventDispatcher;
import ru.kozlovva.messenger.core.domain.message.entity.Message;

@AllArgsConstructor
@Getter
public class MessageCreatedEvent extends EventDispatcher.Event {
    private Message message;
}
