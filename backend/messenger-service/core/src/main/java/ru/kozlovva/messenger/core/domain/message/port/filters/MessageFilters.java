package ru.kozlovva.messenger.core.domain.message.port.filters;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import ru.kozlovva.messenger.core.common.Filter;

@Data
@SuperBuilder
public class MessageFilters extends Filter {
    private String roomId;
}
