package ru.kozlovva.messenger.adapter.out.persistence.user;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import ru.kozlovva.messenger.adapter.out.persistence.ObjectIdGenerator;
import ru.kozlovva.messenger.core.domain.user.port.UserIdGenerator;

@Component
public class MongoUserIdGenerator extends ObjectIdGenerator implements UserIdGenerator<ObjectId> {
}
