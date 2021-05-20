package ru.kozlovva.messenger.core.domain.user.usecase.create;

import lombok.EqualsAndHashCode;
import lombok.Value;
import ru.kozlovva.messenger.core.common.SelfValidating;

@EqualsAndHashCode(callSuper = true)
@Value
public class CreateUserCommand extends SelfValidating {
    String username;
    String password;
    String avatar;
}
