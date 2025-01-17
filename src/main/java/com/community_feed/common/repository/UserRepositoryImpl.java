package com.community_feed.common.repository;

import com.community_feed.common.repository.jpa.JpaUserRepository;
import com.community_feed.post.application.interfaces.UserRepository;
import com.community_feed.user.domain.User;
import com.community_feed.user.repository.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    @Override
    public User save(User user) {
        UserEntity savedUserEntity = jpaUserRepository.save(new UserEntity(user));
        return savedUserEntity.toUser();
    }

    @Override
    public User findById(Long id) {
        UserEntity userEntity = jpaUserRepository.findById(id).orElseThrow(IllegalAccessError::new);
        return userEntity.toUser();
    }
}
