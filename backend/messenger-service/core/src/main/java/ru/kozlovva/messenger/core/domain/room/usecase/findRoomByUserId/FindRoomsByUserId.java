package ru.kozlovva.messenger.core.domain.room.usecase.findRoomByUserId;

import lombok.RequiredArgsConstructor;
import ru.kozlovva.messenger.core.common.SearchResult;
import ru.kozlovva.messenger.core.common.UseCase;
import ru.kozlovva.messenger.core.domain.room.entity.Room;
import ru.kozlovva.messenger.core.domain.room.port.RoomRepository;

@RequiredArgsConstructor
public class FindRoomsByUserId implements UseCase<String, SearchResult<Room>> {

    private final RoomRepository roomRepository;

    @Override
    public SearchResult<Room> execute(String s) {
        return roomRepository.findByUserId(s);
    }
}
