package ru.kozlovva.messenger.adapter.out.persistence.message;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import ru.kozlovva.messenger.adapter.out.persistence.ObjectIdGenerator;
import ru.kozlovva.messenger.core.domain.message.port.MessageIdGenerator;

@Component
public class MongoMessageIdGenerator extends ObjectIdGenerator implements MessageIdGenerator<ObjectId> {
}
