package ru.kozlovva.messenger.adapter.in.web.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.kozlovva.messenger.core.domain.message.usecase.create.CreateMessageCommand;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateMessageRequest {
    private String roomId;
    private String userId;
    private String text;

    public CreateMessageCommand toCommand() {
        return new CreateMessageCommand(roomId, userId, text);
    }
}
