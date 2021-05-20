package ru.kozlovva.messenger.core.common.impl;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.kozlovva.messenger.core.common.EventDispatcher;

import java.util.*;

@Slf4j
@NoArgsConstructor
public class DefaultEventDispatcher extends EventDispatcher {
    protected final Map<Class<? extends Event>, List<EventHandler<? extends Event>>> handlers = new HashMap<>();

    @Override
    public <E extends Event> void registerHandler(Class<E> eventType, EventHandler<E> handler) {
        List<EventHandler<? extends Event>> registeredHandlersForEvent = handlers.get(eventType);
        if (registeredHandlersForEvent != null) {
            boolean handlerBeenRegistered = registeredHandlersForEvent
                    .stream()
                    .anyMatch(h -> !h.getClass().equals(handler.getClass()));
            if (handlerBeenRegistered)
                registeredHandlersForEvent.add(handler);
        } else
            handlers.put(eventType, new ArrayList<>(Collections.singletonList(handler)));
    }

    @Override
    public <E extends Event> void dispatch(E event) {
        List<EventHandler<? extends Event>> targetEventHandlers = Objects.requireNonNullElse(handlers.get(event.getClass()), new ArrayList<>());

        targetEventHandlers
                .forEach(handler -> {
                    ((EventHandler<E>) handler).onEvent(event);
                    log.debug("Event {} dispatched to handler {} ", event.getClass().getSimpleName(), handler.toString());
                });

    }
}