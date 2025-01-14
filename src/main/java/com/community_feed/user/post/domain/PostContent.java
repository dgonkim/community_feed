package com.community_feed.user.post.domain;

import lombok.Getter;

@Getter
public class PostContent {

    private final String content;

    public PostContent(String content) {
        if (content == null || content.length() < 5 || content.length() > 500) {
            throw new IllegalArgumentException();
        }
        this.content = content;

    }


}
