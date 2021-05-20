package ru.kozlovva.messenger.adapter.out.persistence.message;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import ru.kozlovva.messenger.adapter.out.persistence.room.RoomDocMapper;
import ru.kozlovva.messenger.adapter.out.persistence.user.UserDocMapper;
import ru.kozlovva.messenger.core.common.DataMapper;
import ru.kozlovva.messenger.core.domain.message.entity.Message;
import ru.kozlovva.messenger.core.domain.message.port.MessageIdGenerator;

@RequiredArgsConstructor
@Component
public class MessageDocMapper implements DataMapper<MessageDoc, Message> {

    private final MessageIdGenerator<ObjectId> idGenerator;
    private final UserDocMapper userDocMapper;
    private final RoomDocMapper roomDocMapper;

    @Override
    public Message map(MessageDoc messageDoc) {
        return new Message(messageDoc.getId().toString(), userDocMapper.map(messageDoc.getUser()), messageDoc.getText(), messageDoc.getCreatedAt(), roomDocMapper.map(messageDoc.getRoom()));
    }

    @Override
    public MessageDoc inverseMap(Message o) {
        return MessageDoc.builder()
                .id(idGenerator.parse(o.getId()))
                .createdAt(o.getCreatedAt())
                .room(roomDocMapper.inverseMap(o.getRoom()))
                .text(o.getText())
                .user(userDocMapper.inverseMap(o.getSender()))
                .build();
    }
}
