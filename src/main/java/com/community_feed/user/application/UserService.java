package com.community_feed.user.application;

import com.community_feed.post.application.dto.CreateUserRequestDto;
import com.community_feed.post.application.interfaces.UserRepository;
import com.community_feed.user.domain.User;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserRequestDto dto){
        return null;
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

}
