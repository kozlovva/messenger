package ru.kozlovva.messenger.core.domain.user.usecase.signIn;

import lombok.EqualsAndHashCode;
import lombok.Value;
import ru.kozlovva.messenger.core.common.SelfValidating;

@EqualsAndHashCode(callSuper = true)
@Value
public class SignInCommand extends SelfValidating {
    String username;
    String password;
}
