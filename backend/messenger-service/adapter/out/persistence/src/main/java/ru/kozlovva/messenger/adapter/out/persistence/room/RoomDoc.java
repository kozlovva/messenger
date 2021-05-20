package ru.kozlovva.messenger.adapter.out.persistence.room;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.kozlovva.messenger.adapter.out.persistence.user.UserDoc;
import ru.kozlovva.messenger.core.domain.user.entity.User;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@Document
public class RoomDoc {
    private ObjectId id;
    private String title;

    @DBRef
    private UserDoc owner;

    @DBRef
    private List<UserDoc> members;
    private LocalDateTime createdAt;
}
