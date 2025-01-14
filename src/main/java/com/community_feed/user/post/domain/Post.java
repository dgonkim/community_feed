package com.community_feed.user.post.domain;

import com.community_feed.user.domain.User;

public class Post {

//    private final User author;
    private final Long authorId;
    private final PostContent content;

    public Post(User author, String content, PostContent postContent) {
        if (author == null) {
            throw new IllegalArgumentException();
        }

//        this.author = author;
        this.authorId = author.getId();
        this.content = postContent;
    }



}
