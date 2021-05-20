package ru.kozlovva.messenger.core.domain.room.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kozlovva.messenger.core.domain.user.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room {
    private String id;
    private String title;
    private User owner;
    private List<User> members = new ArrayList<>();
    private LocalDateTime createdAt;

    public Room(String id, String title, User owner) {
        this.id = id;
        this.title = title;
        this.members = Collections.singletonList(owner);
    }

    public Room(String id, String title, User owner, List<User> members) {
        this.id = id;
        this.title = title;
        this.members.add(owner);
        if (members.size() > 0)
            this.members.addAll(members);
        this.owner = owner;
    }
}
