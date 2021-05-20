package ru.kozlovva.messenger.adapter.out.persistence.room;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;
import ru.kozlovva.messenger.adapter.out.persistence.ObjectIdGenerator;
import ru.kozlovva.messenger.core.common.SearchResult;
import ru.kozlovva.messenger.core.domain.room.entity.Room;
import ru.kozlovva.messenger.core.domain.room.port.RoomIdGenerator;
import ru.kozlovva.messenger.core.domain.room.port.RoomRepository;
import ru.kozlovva.messenger.core.domain.room.port.filters.RoomFilters;

import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class MongoRoomRepository implements RoomRepository {

    private final RoomIdGenerator<ObjectId> idGenerator;
    private final SpringDataRoomRepository springDataRoomRepository;
    private final RoomDocMapper roomDocMapper;

    @Override
    public SearchResult<Room> findByUserId(String userId) {
        return SearchResult.of(
                springDataRoomRepository.findAllByUserId(userId).stream().map(roomDocMapper::map).collect(Collectors.toList()),
                springDataRoomRepository.count()
        );
    }

    @Override
    public Optional<Room> findById(String s) {
        return springDataRoomRepository.findById(idGenerator.parse(s))
                .map(roomDocMapper::map);
    }

    @Override
    public SearchResult<Room> findAll(RoomFilters filter) {
        return null;
    }

    @Override
    public void save(Room room) {
        springDataRoomRepository.save(roomDocMapper.inverseMap(room));
    }

    @Override
    public void delete(String s) {
        springDataRoomRepository.deleteById(idGenerator.parse(s));
    }

    @Override
    public Long count() {
        return springDataRoomRepository.count();
    }
}
