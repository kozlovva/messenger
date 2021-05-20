package ru.kozlovva.messenger.adapter.in.web.user;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    private String id;
    private String username;
    private String avatar;

    public static User from(ru.kozlovva.messenger.core.domain.user.entity.User user) {
        return User.builder()
                .id(user.getId())
                .username(user.getUsername())
                .avatar(user.getAvatar())
                .build();
    }
}
