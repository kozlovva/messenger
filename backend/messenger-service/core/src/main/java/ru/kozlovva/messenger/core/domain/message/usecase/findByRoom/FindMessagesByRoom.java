package ru.kozlovva.messenger.core.domain.message.usecase.findByRoom;

import lombok.RequiredArgsConstructor;
import ru.kozlovva.messenger.core.common.SearchResult;
import ru.kozlovva.messenger.core.common.UseCase;
import ru.kozlovva.messenger.core.domain.message.entity.Message;
import ru.kozlovva.messenger.core.domain.message.port.MessageRepository;
import ru.kozlovva.messenger.core.domain.message.port.filters.MessageFilters;

@RequiredArgsConstructor
public class FindMessagesByRoom implements UseCase<MessageFilters, SearchResult<Message>> {

    private final MessageRepository messageRepository;

    @Override
    public SearchResult<Message> execute(MessageFilters messageFilters) {
        return messageRepository.findByRoom(messageFilters);
    }
}
