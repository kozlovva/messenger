package ru.kozlovva.messenger.adapter.out.persistence;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import ru.kozlovva.messenger.core.common.IdGenerator;

@Component
public class ObjectIdGenerator implements IdGenerator<ObjectId> {

    @Override
    public String generate() {
        return ObjectId.get().toString();
    }

    @Override
    public ObjectId parse(String s) {
        return new ObjectId(s);
    }
}
