package ru.kozlovva.messenger.core.common;

public interface DataMapper<I, O> {

    O map(I i);

    I inverseMap(O o);

}
