package com.community_feed.common.repository.jpa;

import com.community_feed.user.domain.User;
import com.community_feed.user.repository.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {


}
