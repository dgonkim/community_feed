package com.community_feed.post.application;

import com.community_feed.post.application.dto.CreateUserRequestDto;
import com.community_feed.post.application.interfaces.UserRepository;
import com.community_feed.user.domain.User;
import com.community_feed.user.domain.UserInfo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(CreateUserRequestDto dto){
        UserInfo info = new UserInfo(dto.name(), dto.profileImageUrl());
        User user = new User(null, info);
        return userRepository.save(user);
    }




}
