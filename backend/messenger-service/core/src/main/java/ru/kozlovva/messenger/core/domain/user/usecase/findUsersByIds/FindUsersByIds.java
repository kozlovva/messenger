package ru.kozlovva.messenger.core.domain.user.usecase.findUsersByIds;

import lombok.RequiredArgsConstructor;
import ru.kozlovva.messenger.core.common.UseCase;
import ru.kozlovva.messenger.core.domain.user.entity.User;
import ru.kozlovva.messenger.core.domain.user.port.UserRepository;

import java.util.List;

@RequiredArgsConstructor
public class FindUsersByIds implements UseCase<List<String>, List<User>> {

    private final UserRepository userRepository;

    @Override
    public List<User> execute(List<String> ids) {
        return userRepository.findUsersByIds(ids);
    }
}
