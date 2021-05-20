package ru.kozlovva.messenger.core.domain.user.usecase.signUp;

import lombok.RequiredArgsConstructor;
import ru.kozlovva.messenger.core.common.UseCase;
import ru.kozlovva.messenger.core.domain.user.entity.User;
import ru.kozlovva.messenger.core.domain.user.usecase.create.CreateUser;
import ru.kozlovva.messenger.core.domain.user.usecase.create.CreateUserCommand;
import ru.kozlovva.messenger.core.domain.user.usecase.existByUsername.ExistUserByUsername;

@RequiredArgsConstructor
public class SignUp implements UseCase<SignUpCommand, User> {

    private final ExistUserByUsername existUserByUsername;
    private final CreateUser createUser;

    @Override
    public User execute(SignUpCommand registerUserCommand) {
        if (existUserByUsername.execute(registerUserCommand.getUsername()))
            throw new UserAlreadyExistException(registerUserCommand.getUsername());

        return createUser.execute(new CreateUserCommand(registerUserCommand.getUsername(), registerUserCommand.getPassword(), registerUserCommand.getAvatar()));
    }
}
