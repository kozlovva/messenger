package ru.kozlovva.messenger.adapter.out.persistence.message;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.kozlovva.messenger.adapter.out.persistence.room.RoomDoc;
import ru.kozlovva.messenger.adapter.out.persistence.user.UserDoc;

import java.time.LocalDateTime;

@Builder
@Data
@Document
public class MessageDoc {

    private ObjectId id;

    @DBRef
    private UserDoc user;
    private String text;
    private LocalDateTime createdAt;

    @DBRef
    private RoomDoc room;


}
