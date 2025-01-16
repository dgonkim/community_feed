package com.community_feed.user.application;

import com.community_feed.post.application.dto.CreateUserRequestDto;
import com.community_feed.post.application.interfaces.UserRepository;
import com.community_feed.user.domain.User;
import com.community_feed.user.domain.UserInfo;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserRequestDto dto){
        UserInfo info = new UserInfo(dto.name(), dto.profileImageUrl());
        User user = new User(null, info);
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

}
