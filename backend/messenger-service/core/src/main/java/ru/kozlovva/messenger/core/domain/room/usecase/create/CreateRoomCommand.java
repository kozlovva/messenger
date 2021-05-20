package ru.kozlovva.messenger.core.domain.room.usecase.create;

import lombok.EqualsAndHashCode;
import lombok.Value;
import ru.kozlovva.messenger.core.common.SelfValidating;

import javax.validation.constraints.NotNull;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Value
public class CreateRoomCommand extends SelfValidating {

    @NotNull
    String ownerId;

    String title;
    List<String> memberIds;
}
