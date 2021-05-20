package ru.kozlovva.messenger.core.domain.user.usecase.signUp;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String username) {
        super("User with username " + username + " already exist");
    }
}
