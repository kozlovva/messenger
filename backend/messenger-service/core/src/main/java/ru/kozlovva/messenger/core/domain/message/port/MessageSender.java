package ru.kozlovva.messenger.core.domain.message.port;

import ru.kozlovva.messenger.core.domain.message.entity.Message;

public interface MessageSender {
    void send(Message message);
}
