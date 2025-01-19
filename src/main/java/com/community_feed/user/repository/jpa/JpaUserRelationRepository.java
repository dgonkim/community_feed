package com.community_feed.user.repository.jpa;

import com.community_feed.user.repository.entity.UserEntity;
import com.community_feed.user.repository.entity.UserRelationEntity;
import com.community_feed.user.repository.entity.UserRelationIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRelationRepository extends JpaRepository<UserRelationEntity, UserRelationIdEntity> {

}
