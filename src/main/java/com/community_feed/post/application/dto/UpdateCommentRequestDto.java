package com.community_feed.post.application.dto;

public record UpdateCommentRequestDto(Long commentId, Long userId, String content) {



}
