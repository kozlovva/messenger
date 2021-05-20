package ru.kozlovva.messenger.adapter.out.persistence.message;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;
import ru.kozlovva.messenger.adapter.out.persistence.ObjectIdGenerator;
import ru.kozlovva.messenger.core.common.SearchResult;
import ru.kozlovva.messenger.core.domain.message.entity.Message;
import ru.kozlovva.messenger.core.domain.message.port.MessageIdGenerator;
import ru.kozlovva.messenger.core.domain.message.port.MessageRepository;
import ru.kozlovva.messenger.core.domain.message.port.filters.MessageFilters;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MongoMessageRepository implements MessageRepository {

    private final SpringDataMessageRepository springDataMessageRepository;
    private final MessageIdGenerator<ObjectId> idGenerator;
    private final MessageDocMapper messageDocMapper;

    @Override
    public SearchResult<Message> findByRoom(MessageFilters filters) {
        return null;
    }

    @Override
    public Optional<Message> findById(String s) {
        return springDataMessageRepository.findById(idGenerator.parse(s))
                .map(messageDocMapper::map);
    }

    @Override
    public SearchResult<Message> findAll(MessageFilters filter) {
        return null;
    }

    @Override
    public void save(Message message) {
        springDataMessageRepository.save(messageDocMapper.inverseMap(message));
    }

    @Override
    public void delete(String s) {
        springDataMessageRepository.deleteById(idGenerator.parse(s));
    }

    @Override
    public Long count() {
        return springDataMessageRepository.count();
    }
}
