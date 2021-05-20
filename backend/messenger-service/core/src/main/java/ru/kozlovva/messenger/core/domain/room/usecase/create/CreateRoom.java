package ru.kozlovva.messenger.core.domain.room.usecase.create;

import lombok.RequiredArgsConstructor;
import ru.kozlovva.messenger.core.common.UseCase;
import ru.kozlovva.messenger.core.domain.room.entity.Room;
import ru.kozlovva.messenger.core.domain.room.port.RoomIdGenerator;
import ru.kozlovva.messenger.core.domain.room.port.RoomRepository;
import ru.kozlovva.messenger.core.domain.user.usecase.findById.FindUserById;
import ru.kozlovva.messenger.core.domain.user.usecase.findUsersByIds.FindUsersByIds;

@RequiredArgsConstructor
public class CreateRoom implements UseCase<CreateRoomCommand, Room> {

    private final RoomRepository roomRepository;
    private final RoomIdGenerator<?> roomIdGenerator;
    private final FindUserById findUserById;
    private final FindUsersByIds findUsersByIds;

    @Override
    public Room execute(CreateRoomCommand createRoomCommand) {
        var owner = findUserById.execute(createRoomCommand.getOwnerId());
        var members = findUsersByIds.execute(createRoomCommand.getMemberIds());
        var room = new Room(roomIdGenerator.generate(), createRoomCommand.getTitle(), owner, members);
        roomRepository.save(room);
        return room;
    }
}
