package ru.kozlovva.messenger.core.domain.message.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kozlovva.messenger.core.domain.room.entity.Room;
import ru.kozlovva.messenger.core.domain.user.entity.User;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {
    private String id;
    private User sender;
    private String text;
    private LocalDateTime createdAt;
    private Room room;

    public Message(String id, User sender, String text, Room room) {
        this.id = id;
        this.sender = sender;
        this.text = text;
        this.room = room;
    }
}
