package ru.kozlovva.messenger.core.domain.user.usecase.findById;

import lombok.RequiredArgsConstructor;
import ru.kozlovva.messenger.core.common.UseCase;
import ru.kozlovva.messenger.core.domain.user.entity.User;
import ru.kozlovva.messenger.core.domain.user.port.UserRepository;

@RequiredArgsConstructor
public class FindUserById implements UseCase<String, User> {

    private final UserRepository userRepository;

    @Override
    public User execute(String s) {
        return userRepository.findById(s)
                .orElseThrow(UserNotFoundException::new);
    }
}
