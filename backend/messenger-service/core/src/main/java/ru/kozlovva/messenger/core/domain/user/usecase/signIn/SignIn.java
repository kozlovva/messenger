package ru.kozlovva.messenger.core.domain.user.usecase.signIn;

import lombok.RequiredArgsConstructor;
import ru.kozlovva.messenger.core.common.UseCase;
import ru.kozlovva.messenger.core.domain.user.usecase.findById.UserNotFoundException;
import ru.kozlovva.messenger.core.domain.user.usecase.findByUsername.FindUserByUsername;

@RequiredArgsConstructor
public class SignIn implements UseCase<SignInCommand, TokenPair> {

    private final FindUserByUsername findUserByUsername;

    @Override
    public TokenPair execute(SignInCommand signInCommand) {
        var user = findUserByUsername.execute(signInCommand.getUsername())
                .orElseThrow(UserNotFoundException::new);
        if (!user.getPassword().equals(signInCommand.getPassword()))
            throw new InvalidPasswordException();

        return new TokenPair(user.getId(), user.getId());
    }
}
