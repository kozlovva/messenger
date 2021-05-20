package ru.kozlovva.messenger.core.domain.user.port;

import ru.kozlovva.messenger.core.common.CRUDRepository;
import ru.kozlovva.messenger.core.common.Filter;
import ru.kozlovva.messenger.core.domain.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CRUDRepository<User, String, Filter> {
    Optional<User> findByUsername(String username);
    boolean existByUsername(String username);
    List<User> findUsersByIds(List<String> ids);
}
