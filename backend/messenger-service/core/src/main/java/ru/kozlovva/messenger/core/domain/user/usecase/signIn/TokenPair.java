package ru.kozlovva.messenger.core.domain.user.usecase.signIn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TokenPair {
    private String accessToken;
    private String refreshToken;
}
