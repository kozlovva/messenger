package ru.kozlovva.messenger.adapter.in.web.message;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Message {
    private String id;
    private Sender sender;
    private String text;
    private LocalDateTime date;
    private Room room;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Sender {
        private String id;
        private String username;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Room {
        private String id;
        private String title;
    }

    public static Message from(ru.kozlovva.messenger.core.domain.message.entity.Message message) {
        return Message.builder()
                .id(message.getId())
                .text(message.getText())
                .date(message.getCreatedAt())
                .sender(Optional.ofNullable(message.getSender())
                        .map(u -> new Sender(u.getId(), u.getUsername()))
                        .orElse(null))
                .room(Optional.ofNullable(message.getRoom())
                        .map(r -> new Room(r.getId(), r.getTitle()))
                        .orElse(null))
                .build();
    }
}
