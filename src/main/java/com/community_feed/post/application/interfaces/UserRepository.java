package com.community_feed.post.application.interfaces;

import com.community_feed.user.domain.User;

import java.util.Optional;


public interface UserRepository {

    User save(User user);

    User findById(Long id);
 }
