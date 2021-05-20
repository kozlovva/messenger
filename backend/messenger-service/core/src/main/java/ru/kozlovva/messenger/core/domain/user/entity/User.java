package ru.kozlovva.messenger.core.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@AllArgsConstructor(staticName = "newInstance")
@NoArgsConstructor
@Data
public class User {
    private String id;
    private String username;
    private String password;
    private String avatar;
}
