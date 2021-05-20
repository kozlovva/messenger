package ru.kozlovva.messenger.adapter.out.persistence.message;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SpringDataMessageRepository extends MongoRepository<MessageDoc, ObjectId> {

    @Query(value = "{ 'room.id' : ?0}")
    List<MessageDoc> findAllByRoomId(String roomId);
}
