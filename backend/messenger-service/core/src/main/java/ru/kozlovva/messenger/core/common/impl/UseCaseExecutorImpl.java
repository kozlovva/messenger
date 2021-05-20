package ru.kozlovva.messenger.core.common.impl;

import ru.kozlovva.messenger.core.common.UseCase;
import ru.kozlovva.messenger.core.common.UseCaseExecutor;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class UseCaseExecutorImpl implements UseCaseExecutor {

    @Override
    public <RX, I, O> CompletableFuture<RX> execute(UseCase<I, O> useCase, I input, Function<O, RX> outputMapper) {
        return CompletableFuture
                .supplyAsync(() -> input)
                .thenApplyAsync(useCase::execute)
                .thenApplyAsync(outputMapper);
    }
}
