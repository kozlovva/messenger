package ru.kozlovva.messenger.core.domain.message.usecase.create;

import lombok.EqualsAndHashCode;
import lombok.Value;
import ru.kozlovva.messenger.core.common.SelfValidating;

@EqualsAndHashCode(callSuper = true)
@Value
public class CreateMessageCommand extends SelfValidating {
    String roomId;
    String userId;
    String text;

}
