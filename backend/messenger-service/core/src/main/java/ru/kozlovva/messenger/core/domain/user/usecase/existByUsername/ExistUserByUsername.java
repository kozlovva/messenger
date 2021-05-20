package ru.kozlovva.messenger.core.domain.user.usecase.existByUsername;

import lombok.RequiredArgsConstructor;
import ru.kozlovva.messenger.core.common.UseCase;
import ru.kozlovva.messenger.core.domain.user.port.UserRepository;

@RequiredArgsConstructor
public class ExistUserByUsername implements UseCase<String, Boolean> {

    private final UserRepository userRepository;

    @Override
    public Boolean execute(String username) {
        return userRepository.existByUsername(username);
    }
}
