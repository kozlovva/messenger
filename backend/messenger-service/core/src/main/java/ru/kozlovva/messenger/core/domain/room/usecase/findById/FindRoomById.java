package ru.kozlovva.messenger.core.domain.room.usecase.findById;

import lombok.RequiredArgsConstructor;
import ru.kozlovva.messenger.core.common.UseCase;
import ru.kozlovva.messenger.core.domain.room.entity.Room;
import ru.kozlovva.messenger.core.domain.room.port.RoomRepository;

@RequiredArgsConstructor
public class FindRoomById implements UseCase<String, Room> {

    private final RoomRepository roomRepository;

    @Override
    public Room execute(String s) {
        return roomRepository.findById(s)
                .orElseThrow(RoomNotFoundException::new);
    }
}
