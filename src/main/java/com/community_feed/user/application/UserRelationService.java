package com.community_feed.user.application;

import com.community_feed.user.application.dto.FollowUserRequestDto;
import com.community_feed.user.application.interfaces.UserRelationRepository;
import com.community_feed.user.domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRelationService {

    private final UserService userService;
    private final UserRelationRepository userRelationRepository;

    public void follow(FollowUserRequestDto dto) {
        User user = userService.getUser(dto.userId());
        User targetUser = userService.getUser(dto.targetUserId());

        if (userRelationRepository.isAlreadyFollow(user, targetUser)) {
            throw new IllegalArgumentException();
        }

        user.follow(targetUser);
        userRelationRepository.save(user, targetUser);
    }

    public void unfollow(FollowUserRequestDto dto) {
        User user = userService.getUser(dto.userId());
        User targetUser = userService.getUser(dto.targetUserId());

        if (userRelationRepository.isAlreadyFollow(user, targetUser)) {
            throw new IllegalArgumentException();
        }

        user.unfollow(targetUser);
        userRelationRepository.delete(user, targetUser);
    }




}
