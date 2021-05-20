package ru.kozlovva.messenger.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kozlovva.messenger.core.common.EventDispatcher;
import ru.kozlovva.messenger.core.common.UseCaseExecutor;
import ru.kozlovva.messenger.core.common.impl.AsyncEventDispatcher;
import ru.kozlovva.messenger.core.common.impl.UseCaseExecutorImpl;
import ru.kozlovva.messenger.core.domain.message.event.out.MessageCreatedEvent;
import ru.kozlovva.messenger.core.domain.message.handler.SendMessageToRoom;
import ru.kozlovva.messenger.core.domain.message.port.MessageIdGenerator;
import ru.kozlovva.messenger.core.domain.message.port.MessageRepository;
import ru.kozlovva.messenger.core.domain.message.port.MessageSender;
import ru.kozlovva.messenger.core.domain.message.usecase.create.CreateMessage;
import ru.kozlovva.messenger.core.domain.room.port.RoomIdGenerator;
import ru.kozlovva.messenger.core.domain.room.port.RoomRepository;
import ru.kozlovva.messenger.core.domain.room.usecase.create.CreateRoom;
import ru.kozlovva.messenger.core.domain.room.usecase.findById.FindRoomById;
import ru.kozlovva.messenger.core.domain.user.port.UserIdGenerator;
import ru.kozlovva.messenger.core.domain.user.port.UserRepository;
import ru.kozlovva.messenger.core.domain.user.usecase.create.CreateUser;
import ru.kozlovva.messenger.core.domain.user.usecase.existByUsername.ExistUserByUsername;
import ru.kozlovva.messenger.core.domain.user.usecase.findById.FindUserById;
import ru.kozlovva.messenger.core.domain.user.usecase.findByUsername.FindUserByUsername;
import ru.kozlovva.messenger.core.domain.user.usecase.findUsersByIds.FindUsersByIds;
import ru.kozlovva.messenger.core.domain.user.usecase.signIn.SignIn;
import ru.kozlovva.messenger.core.domain.user.usecase.signUp.SignUp;

@Configuration
public class CoreConfig {

    @Bean
    public CreateUser createUser(UserRepository userRepository, UserIdGenerator<?> userIdGenerator) {
        return new CreateUser(userRepository, userIdGenerator);
    }

    @Bean
    public FindUserByUsername findUserByUsername(UserRepository userRepository) {
        return new FindUserByUsername(userRepository);
    }

    @Bean
    public FindUserById findUserById(UserRepository userRepository) {
        return new FindUserById(userRepository);
    }

    @Bean
    public ExistUserByUsername existUserByUsername(UserRepository userRepository) {
        return new ExistUserByUsername(userRepository);
    }

    @Bean
    public SignUp signUp(CreateUser createUser, ExistUserByUsername existUserByUsername) {
        return new SignUp(existUserByUsername, createUser);
    }

    @Bean
    public SignIn signIn(FindUserByUsername findUserByUsername) {
        return new SignIn(findUserByUsername);
    }

    @Bean
    public UseCaseExecutor useCaseExecutor() {
        return new UseCaseExecutorImpl();
    }

    @Bean
    public FindRoomById findRoomById(RoomRepository roomRepository) {
        return new FindRoomById(roomRepository);
    }

    @Bean
    public CreateMessage createMessage(
            MessageRepository messageRepository,
            MessageIdGenerator<?> messageIdGenerator,
            FindRoomById findRoomById,
            FindUserById findUserById,
            EventDispatcher eventDispatcher) {
        return new CreateMessage(messageRepository, messageIdGenerator, findRoomById, findUserById, eventDispatcher);
    }

    @Bean
    public EventDispatcher eventDispatcher(MessageSender messageSender) {
        var e = new AsyncEventDispatcher();
        e.registerHandler(MessageCreatedEvent.class, new SendMessageToRoom(messageSender));
        return e;
    }

    @Bean
    public FindUsersByIds findUsersByIds(UserRepository userRepository) {
        return new FindUsersByIds(userRepository);
    }

    @Bean
    public CreateRoom createRoom(RoomRepository roomRepository, RoomIdGenerator<?> roomIdGenerator, FindUserById findUserById, FindUsersByIds findUsersByIds) {
        return new CreateRoom(roomRepository, roomIdGenerator, findUserById, findUsersByIds);
    }
}
