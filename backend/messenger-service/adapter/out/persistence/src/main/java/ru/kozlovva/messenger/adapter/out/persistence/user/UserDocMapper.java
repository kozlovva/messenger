package ru.kozlovva.messenger.adapter.out.persistence.user;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import ru.kozlovva.messenger.core.common.DataMapper;
import ru.kozlovva.messenger.core.domain.user.entity.User;
import ru.kozlovva.messenger.core.domain.user.port.UserIdGenerator;

@RequiredArgsConstructor
@Component
public class UserDocMapper implements DataMapper<UserDoc, User>{

    private final UserIdGenerator<ObjectId> idGenerator;

    @Override
    public User map(UserDoc userDoc) {
        return User.newInstance(userDoc.getId().toString(), userDoc.getUsername(), userDoc.getPassword(), userDoc.getAvatar());
    }

    @Override
    public UserDoc inverseMap(User o) {
        return UserDoc.builder()
                .id(idGenerator.parse(o.getId()))
                .password(o.getPassword())
                .username(o.getUsername())
                .avatar(o.getAvatar())
                .build();
    }
}
