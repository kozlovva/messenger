package ru.kozlovva.messenger.adapter.in.web.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.kozlovva.messenger.core.domain.user.usecase.signIn.SignInCommand;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SingInRequest {
    private String username;
    private String password;

    public SignInCommand toCommand() {
        return new SignInCommand(username, password);
    }
}
