package ru.kozlovva.messenger.core.common;

public interface UseCase<I, O> {

    O execute(I i);

}
