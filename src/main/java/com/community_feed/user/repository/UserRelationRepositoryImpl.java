package com.community_feed.user.repository;

import com.community_feed.post.application.interfaces.UserRepository;
import com.community_feed.user.application.interfaces.UserRelationRepository;
import com.community_feed.user.domain.User;
import com.community_feed.user.repository.entity.UserEntity;
import com.community_feed.user.repository.entity.UserRelationEntity;
import com.community_feed.user.repository.entity.UserRelationIdEntity;
import com.community_feed.user.repository.jpa.JpaUserRelationRepository;
import com.community_feed.user.repository.jpa.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRelationRepositoryImpl implements UserRelationRepository {

    private final JpaUserRelationRepository jpaUserRelationRepository;
    private final JpaUserRepository jpaUserRepository;

    @Override
    public boolean isAlreadyFollow(User user, User targetUser) {
        UserRelationIdEntity id = new UserRelationIdEntity(user.getId(), targetUser.getId());
        return jpaUserRelationRepository.existsById(id);
    }

    @Override
    @Transactional
    public void save(User user, User targetUser) {
        UserRelationEntity entity = new UserRelationEntity(user.getId(), targetUser.getId());
        jpaUserRelationRepository.save(entity);
        //save를 하기위해서는 user의 following 숫자 증가 (나는 following한 유저가 traget user)
        //targetUser의 follower 숫자를 증가 (target user 입장에서 User를 follower했기에 본인 follower가 증가)
        jpaUserRepository.saveAll(List.of(new UserEntity(user), new UserEntity(targetUser)));
    }

    @Override
    @Transactional
    public void delete(User user, User targetUser) {
        UserRelationIdEntity entity = new UserRelationIdEntity(user.getId(), targetUser.getId());
        jpaUserRelationRepository.deleteById(entity);
        //save를 하기위해서는 user의 following 숫자 증가 (나는 following한 유저가 traget user)
        //targetUser의 follower 숫자를 증가 (target user 입장에서 User를 follower했기에 본인 follower가 증가)
        jpaUserRepository.saveAll(List.of(new UserEntity(user), new UserEntity(targetUser)));
    }
}
