package ru.kozlovva.messenger.core.domain.user.usecase.findByUsername;

import lombok.RequiredArgsConstructor;
import ru.kozlovva.messenger.core.common.UseCase;
import ru.kozlovva.messenger.core.domain.user.entity.User;
import ru.kozlovva.messenger.core.domain.user.port.UserRepository;

import java.util.Optional;

@RequiredArgsConstructor
public class FindUserByUsername implements UseCase<String, Optional<User>> {

    private final UserRepository userRepository;

    @Override
    public Optional<User> execute(String username) {
        return userRepository.findByUsername(username);
    }
}
