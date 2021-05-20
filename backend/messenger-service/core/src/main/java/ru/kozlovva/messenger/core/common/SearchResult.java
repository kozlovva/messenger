package ru.kozlovva.messenger.core.common;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SearchResult<T> {
    private List<T> items = new ArrayList<>();
    private Long count = 0L;

    public static <T> SearchResult<T> of(List<T> items, Long count) {
        return new SearchResult<>(items, count);
    }
}
