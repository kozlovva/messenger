package ru.kozlovva.messenger.adapter.out.persistence.user;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import ru.kozlovva.messenger.adapter.out.persistence.ObjectIdGenerator;
import ru.kozlovva.messenger.core.common.Filter;
import ru.kozlovva.messenger.core.common.SearchResult;
import ru.kozlovva.messenger.core.domain.user.entity.User;
import ru.kozlovva.messenger.core.domain.user.port.UserIdGenerator;
import ru.kozlovva.messenger.core.domain.user.port.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class MongoUserRepository implements UserRepository {

    private final SpringDataUserRepository springDataUserRepository;
    private final UserIdGenerator<ObjectId> objectIdGenerator;
    private final UserDocMapper userDocMapper;

    @Override
    public Optional<User> findByUsername(String username) {
        return springDataUserRepository.findByUsername(username)
                .map(userDocMapper::map);
    }

    @Override
    public boolean existByUsername(String username) {
        return springDataUserRepository.existsByUsername(username);
    }

    @Override
    public Optional<User> findById(String s) {
        return springDataUserRepository.findById(objectIdGenerator.parse(s))
                .map(userDocMapper::map);
    }

    @Override
    public SearchResult<User> findAll(Filter filter) {
        var result = springDataUserRepository.findAll(PageRequest.of(filter.getOffset(), filter.getLimit()));
        return SearchResult.of(
                result.get().map(userDocMapper::map).collect(Collectors.toList()),
                springDataUserRepository.count()
        );
    }

    @Override
    public void save(User user) {
        springDataUserRepository.save(userDocMapper.inverseMap(user));
    }

    @Override
    public void delete(String s) {
        springDataUserRepository.deleteById(objectIdGenerator.parse(s));
    }


    //TODO реализвать позже
    @Override
    public List<User> findUsersByIds(List<String> ids) {
        if (ids == null || ids.size() == 0)
            return new ArrayList<>();
        return null;
    }

    @Override
    public Long count() {
        return springDataUserRepository.count();
    }
}
