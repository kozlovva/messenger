package ru.kozlovva.messenger.core.domain.user.usecase.findById;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User not found");
    }
}
