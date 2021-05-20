package ru.kozlovva.messenger.adapter.in.web.message;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.kozlovva.messenger.core.common.UseCaseExecutor;
import ru.kozlovva.messenger.core.domain.message.usecase.create.CreateMessage;

@RequiredArgsConstructor
@Component
public class MessageController implements MessageResource {

    private final CreateMessage createMessage;
    private final UseCaseExecutor useCaseExecutor;

    @Override
    public void createMessage(CreateMessageRequest request) {
        useCaseExecutor.execute(
                createMessage,
                request.toCommand(),
                o -> o
        );
    }
}
