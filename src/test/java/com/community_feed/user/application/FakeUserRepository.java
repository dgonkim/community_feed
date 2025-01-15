package com.community_feed.user.application;

import com.community_feed.post.application.interfaces.UserRepository;
import com.community_feed.user.domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class FakeUserRepository implements UserRepository {

    private final Map<Long, User> store = new HashMap<>();

    @Override
    public User save(User user) {
        if (user.getId() != null) {
            store.put(user.getId(), user);
        }
        long id = store.size() + 1L;
        User newUser = new User(id, user.getInfo());
        store.put(id, newUser);
        return newUser;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }
}
