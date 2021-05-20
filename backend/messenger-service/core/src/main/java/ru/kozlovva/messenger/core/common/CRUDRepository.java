package ru.kozlovva.messenger.core.common;

import java.util.Optional;

public interface CRUDRepository<T, ID, F extends Filter> {
    Optional<T> findById(ID id);
    SearchResult<T> findAll(F filter);
    void save(T t);
    void delete(ID id);
    Long count();
}
