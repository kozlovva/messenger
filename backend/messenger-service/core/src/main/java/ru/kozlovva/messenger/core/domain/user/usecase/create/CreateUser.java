package ru.kozlovva.messenger.core.domain.user.usecase.create;

import lombok.RequiredArgsConstructor;
import ru.kozlovva.messenger.core.common.UseCase;
import ru.kozlovva.messenger.core.domain.user.entity.User;
import ru.kozlovva.messenger.core.domain.user.port.UserIdGenerator;
import ru.kozlovva.messenger.core.domain.user.port.UserRepository;

@RequiredArgsConstructor
public class CreateUser implements UseCase<CreateUserCommand, User> {

    private final UserRepository userRepository;
    private final UserIdGenerator<?> userIdGenerator;

    @Override
    public User execute(CreateUserCommand createUserCommand) {
        var user = User.newInstance(userIdGenerator.generate(), createUserCommand.getUsername(), createUserCommand.getPassword(), createUserCommand.getAvatar());
        userRepository.save(user);
        return user;
    }
}
