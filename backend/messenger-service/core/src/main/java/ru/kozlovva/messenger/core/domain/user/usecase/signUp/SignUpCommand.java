package ru.kozlovva.messenger.core.domain.user.usecase.signUp;

import lombok.EqualsAndHashCode;
import lombok.Value;
import ru.kozlovva.messenger.core.common.SelfValidating;

import javax.validation.constraints.NotBlank;


@EqualsAndHashCode(callSuper = true)
@Value
public class SignUpCommand extends SelfValidating {

    @NotBlank
    String username;

    @NotBlank
    String password;

    String avatar;
}
