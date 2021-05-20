package ru.kozlovva.messenger.adapter.out.persistence.user;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document
public class UserDoc {
    private ObjectId id;
    private String username;
    private String password;
    private String avatar;
}
