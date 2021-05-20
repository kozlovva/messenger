package ru.kozlovva.messenger.core.domain.message.usecase.create;

import lombok.RequiredArgsConstructor;
import ru.kozlovva.messenger.core.common.EventDispatcher;
import ru.kozlovva.messenger.core.common.UseCase;
import ru.kozlovva.messenger.core.domain.message.entity.Message;
import ru.kozlovva.messenger.core.domain.message.event.out.MessageCreatedEvent;
import ru.kozlovva.messenger.core.domain.message.port.MessageIdGenerator;
import ru.kozlovva.messenger.core.domain.message.port.MessageRepository;
import ru.kozlovva.messenger.core.domain.room.usecase.findById.FindRoomById;
import ru.kozlovva.messenger.core.domain.user.usecase.findById.FindUserById;

@RequiredArgsConstructor
public class CreateMessage implements UseCase<CreateMessageCommand, Message> {

    private final MessageRepository messageRepository;
    private final MessageIdGenerator<?> messageIdGenerator;
    private final FindRoomById findRoomById;
    private final FindUserById findUserById;
    private final EventDispatcher eventDispatcher;

    @Override
    public Message execute(CreateMessageCommand createMessageCommand) {
        var user = findUserById.execute(createMessageCommand.getUserId());
        var room = findRoomById.execute(createMessageCommand.getRoomId());
        var message = new Message(messageIdGenerator.generate(), user, createMessageCommand.getText(), room);
        messageRepository.save(message);

        eventDispatcher.dispatch(new MessageCreatedEvent(message));

        return message;
    }
}
