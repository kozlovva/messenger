package ru.kozlovva.messenger.adapter.in.web.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.kozlovva.messenger.core.domain.user.usecase.signUp.SignUpCommand;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SignUpRequest {
    private String username;
    private String password;
    private String avatar;

    public SignUpCommand toCommand() {
        return new SignUpCommand(username, password, avatar);
    }
}
