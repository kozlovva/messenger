package ru.kozlovva.messenger.adapter.out.persistence.user;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataUserRepository extends MongoRepository<UserDoc, ObjectId> {
    Optional<UserDoc> findByUsername(String username);
    Boolean existsByUsername(String username);
    List<UserDoc> findAllById(List<String> ids);
}
