package com.community_feed.post.application.dto;

import com.community_feed.post.domain.content.PostPublicationState;

public record CreatePostRequestDto(Long userId, String content, PostPublicationState state) {



}
