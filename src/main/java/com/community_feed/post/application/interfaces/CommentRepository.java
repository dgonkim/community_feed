package com.community_feed.post.application.interfaces;

import com.community_feed.post.domain.Post;
import com.community_feed.post.domain.comment.Comment;
import com.community_feed.user.domain.User;

import java.util.Optional;

public interface CommentRepository {

    Comment save(Comment comment);
    Optional<Comment> findById(Long id);

}
