package ru.kozlovva.messenger.core.domain.room.usecase.findById;

public class RoomNotFoundException extends RuntimeException {

    public RoomNotFoundException() {
        super("Room not found");
    }
}
