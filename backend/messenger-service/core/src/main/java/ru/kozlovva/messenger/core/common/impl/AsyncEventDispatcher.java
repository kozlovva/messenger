package ru.kozlovva.messenger.core.common.impl;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class AsyncEventDispatcher extends DefaultEventDispatcher {

    @Override
    public <E extends Event> void dispatch(E event) {

        List<EventHandler<? extends Event>> targetEventHandlers = Objects.requireNonNullElse(handlers.get(event.getClass()), new ArrayList<>());

        targetEventHandlers
                .forEach(handler -> {
                    CompletableFuture.runAsync(() -> ((EventHandler<E>) handler).onEvent(event));
                    log.debug("Event {} dispatched to handler {} ", event.getClass().getSimpleName(), handler.toString());
                });
    }
}