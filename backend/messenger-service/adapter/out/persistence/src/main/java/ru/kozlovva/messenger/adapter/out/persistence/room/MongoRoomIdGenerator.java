package ru.kozlovva.messenger.adapter.out.persistence.room;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import ru.kozlovva.messenger.adapter.out.persistence.ObjectIdGenerator;
import ru.kozlovva.messenger.core.domain.room.port.RoomIdGenerator;

@Component
public class MongoRoomIdGenerator extends ObjectIdGenerator implements RoomIdGenerator<ObjectId> {
}
