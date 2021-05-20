package ru.kozlovva.messenger.core.domain.pushNotification.port;

import ru.kozlovva.messenger.core.domain.pushNotification.entity.PushNotification;

public interface PushNotificationSender {
    void send(PushNotification pushNotification);
}
