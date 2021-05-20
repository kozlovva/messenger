package ru.kozlovva.messenger.core.common;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class EventDispatcher {
    public abstract <E extends Event> void registerHandler(Class<E> eventType, EventHandler<E> handler);

    public abstract <E extends Event> void dispatch(E event);

    public interface EventHandler<E extends Event> {
        void onEvent(E event);
    }

    @Getter
    public static class Event {
        private String id = UUID.randomUUID().toString();
        private LocalDateTime date = LocalDateTime.now();
    }
}
