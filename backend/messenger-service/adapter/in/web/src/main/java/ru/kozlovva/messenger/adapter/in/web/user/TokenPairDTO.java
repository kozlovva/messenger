package ru.kozlovva.messenger.adapter.in.web.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kozlovva.messenger.core.domain.user.usecase.signIn.TokenPair;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TokenPairDTO {
    private String accessToken;
    private String refreshToken;

    public static TokenPairDTO from(TokenPair tokenPair) {
        return new TokenPairDTO(tokenPair.getAccessToken(), tokenPair.getRefreshToken());
    }
}
