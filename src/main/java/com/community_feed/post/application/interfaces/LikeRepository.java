package com.community_feed.post.application.interfaces;

import com.community_feed.post.domain.Post;
import com.community_feed.user.domain.User;

import java.util.Optional;

public interface LikeRepository {

    boolean checkLike(Post post, User user);
    void like(Post post, User user);
    void unlike(Post post, User user);
}
