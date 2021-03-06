package ru.kozlovva.messenger.core.common;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public interface UseCaseExecutor {
    <RX, I, O> CompletableFuture<RX> execute(
            UseCase<I, O> useCase,
            I input,
            Function<O, RX> outputMapper);
}