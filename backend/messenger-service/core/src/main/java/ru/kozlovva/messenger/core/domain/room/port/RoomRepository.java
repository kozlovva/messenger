package ru.kozlovva.messenger.core.domain.room.port;

import ru.kozlovva.messenger.core.common.CRUDRepository;
import ru.kozlovva.messenger.core.common.SearchResult;
import ru.kozlovva.messenger.core.domain.room.entity.Room;
import ru.kozlovva.messenger.core.domain.room.port.filters.RoomFilters;

public interface RoomRepository extends CRUDRepository<Room, String, RoomFilters> {
    SearchResult<Room> findByUserId(String userId);
}
