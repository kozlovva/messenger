package ru.kozlovva.messenger.core.domain.room.port.filters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.kozlovva.messenger.core.common.Filter;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class RoomFilters extends Filter {
    private String userId;
}
