package com.community_feed.user.application.dto;

import com.community_feed.user.domain.User;

public record GetUserResponseDto(Long id, String name, String profileImage, Integer followingCount, Integer followerCount){

    public GetUserResponseDto(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getProfileImage(),
                user.getFollowingCount(),
                user.getFollowerCount());
    }
}
