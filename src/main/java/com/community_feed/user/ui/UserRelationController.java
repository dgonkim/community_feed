package com.community_feed.user.ui;

import com.community_feed.common.ui.Response;
import com.community_feed.post.application.dto.CreateUserRequestDto;
import com.community_feed.user.application.UserRelationService;
import com.community_feed.user.application.UserService;
import com.community_feed.user.application.dto.FollowUserRequestDto;
import com.community_feed.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relation")
@RequiredArgsConstructor
public class UserRelationController {

    private final UserRelationService relationService;

    @PostMapping("/follow")
    public Response<Void> followUser(@RequestBody FollowUserRequestDto dto) {
        relationService.follow(dto);
        return Response.ok(null);
    }

    @PostMapping("/unfollow")
    public Response<Void> unfollowUser(@RequestBody FollowUserRequestDto dto) {
        relationService.unfollow(dto);
        return Response.ok(null);
    }



}
