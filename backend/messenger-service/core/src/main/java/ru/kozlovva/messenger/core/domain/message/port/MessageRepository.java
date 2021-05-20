package ru.kozlovva.messenger.core.domain.message.port;

import ru.kozlovva.messenger.core.common.CRUDRepository;
import ru.kozlovva.messenger.core.common.SearchResult;
import ru.kozlovva.messenger.core.domain.message.entity.Message;
import ru.kozlovva.messenger.core.domain.message.port.filters.MessageFilters;

public interface MessageRepository extends CRUDRepository<Message, String, MessageFilters> {
    SearchResult<Message> findByRoom(MessageFilters filters);
}
