package ru.kozlovva.messenger.core.common;

public interface IdGenerator<T> {
    String generate();

    T parse(String s);
}
