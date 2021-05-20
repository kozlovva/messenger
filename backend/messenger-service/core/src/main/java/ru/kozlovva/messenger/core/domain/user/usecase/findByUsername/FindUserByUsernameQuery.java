package ru.kozlovva.messenger.core.domain.user.usecase.findByUsername;

import lombok.Value;

@Value
public class FindUserByUsernameQuery {
    String username;
}
