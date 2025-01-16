package com.community_feed.post.application.dto;

import com.community_feed.post.domain.content.PostPublicationState;

public record CreateCommentRequestDto(Long postId, Long userId, String content) {



}
