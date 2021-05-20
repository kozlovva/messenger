package ru.kozlovva.messenger.adapter.out.persistence.room;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SpringDataRoomRepository extends MongoRepository<RoomDoc, ObjectId> {

    @Query(value = "{ 'members.id' : ?0}")
    List<RoomDoc> findAllByUserId(String userId);

}
