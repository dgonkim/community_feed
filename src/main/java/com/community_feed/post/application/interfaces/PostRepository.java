package com.community_feed.post.application.interfaces;

import com.community_feed.post.domain.Post;
import com.community_feed.user.domain.User;

import java.util.Optional;

public interface PostRepository {

    Post save(Post post);

    Optional<Post> findById(Long id);
}
