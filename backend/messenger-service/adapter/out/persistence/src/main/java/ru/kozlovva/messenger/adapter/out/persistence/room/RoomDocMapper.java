package ru.kozlovva.messenger.adapter.out.persistence.room;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import ru.kozlovva.messenger.adapter.out.persistence.user.UserDocMapper;
import ru.kozlovva.messenger.core.common.DataMapper;
import ru.kozlovva.messenger.core.domain.room.entity.Room;
import ru.kozlovva.messenger.core.domain.room.port.RoomIdGenerator;
import ru.kozlovva.messenger.core.domain.user.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class RoomDocMapper implements DataMapper<RoomDoc, Room> {

    private final RoomIdGenerator<ObjectId> roomIdGenerator;
    private final UserDocMapper userDocMapper;

    @Override
    public Room map(RoomDoc roomDoc) {
        return new Room(
                roomDoc.getId().toString(),
                roomDoc.getTitle(),
                userDocMapper.map(roomDoc.getOwner()),
                roomDoc.getMembers().stream().map(userDocMapper::map).collect(Collectors.toList()),
                roomDoc.getCreatedAt()
        );
    }

    @Override
    public RoomDoc inverseMap(Room o) {
        return RoomDoc.builder()
                .createdAt(o.getCreatedAt())
                .id(roomIdGenerator.parse(o.getId()))
                .members(o.getMembers().stream().map(userDocMapper::inverseMap).collect(Collectors.toList()))
                .owner(userDocMapper.inverseMap(o.getOwner()))
                .title(o.getTitle())
                .build();
    }
}
