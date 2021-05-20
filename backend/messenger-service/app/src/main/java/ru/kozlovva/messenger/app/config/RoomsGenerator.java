package ru.kozlovva.messenger.app.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import ru.kozlovva.messenger.core.common.Filter;
import ru.kozlovva.messenger.core.domain.room.port.RoomRepository;
import ru.kozlovva.messenger.core.domain.room.usecase.create.CreateRoom;
import ru.kozlovva.messenger.core.domain.room.usecase.create.CreateRoomCommand;
import ru.kozlovva.messenger.core.domain.user.port.UserRepository;

import java.util.ArrayList;

@RequiredArgsConstructor
@Configuration
public class RoomsGenerator implements CommandLineRunner {

    private final CreateRoom createRoom;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roomRepository.count() > 0)
            return;
        userRepository.findAll(Filter.builder()
                .limit(10)
                .offset(0)
                .build()).getItems()
                .forEach(u -> {
                    createRoom.execute(new CreateRoomCommand(u.getId(), "Test", new ArrayList<>()));
                });
    }
}
