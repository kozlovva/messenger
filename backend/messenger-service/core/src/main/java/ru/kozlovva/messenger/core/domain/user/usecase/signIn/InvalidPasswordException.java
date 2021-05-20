package ru.kozlovva.messenger.core.domain.user.usecase.signIn;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException() {
        super("Invalid password");
    }
}
