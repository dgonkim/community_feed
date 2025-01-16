package com.community_feed.post.application;

import com.community_feed.post.application.dto.CreateCommentRequestDto;
import com.community_feed.post.application.dto.LikeRequestDto;
import com.community_feed.post.application.dto.UpdateCommentRequestDto;
import com.community_feed.post.application.interfaces.CommentRepository;
import com.community_feed.post.application.interfaces.LikeRepository;
import com.community_feed.post.domain.Post;
import com.community_feed.post.domain.comment.Comment;
import com.community_feed.user.application.UserService;
import com.community_feed.user.domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final PostService postService;
    private final LikeRepository likeRepository;

    public Comment getComment(Long id) {
        return commentRepository.findById(id).orElseThrow(IllegalAccessError::new);
    }


    public Comment createdComment(CreateCommentRequestDto dto) {
        Post post = postService.getPost(dto.postId());
        User user = userService.getUser(dto.userId());

        Comment comment = Comment.createComment(post, user, dto.content());
        return commentRepository.save(comment);
    }

    public Comment updateComment(UpdateCommentRequestDto dto) {
        Comment comment = getComment(dto.commentId());
        User user = userService.getUser(dto.userId());

        comment.updateComment(user, dto.content());
        return commentRepository.save(comment);
    }

    public void likeComment(LikeRequestDto dto) {
        Comment comment = getComment(dto.targetId());
        User user = userService.getUser(dto.userId());

        //이미 좋아요를 누른 상태면
        if (likeRepository.checkLike(comment, user)) {
            return;
        }

        comment.like(user);
        likeRepository.like(comment, user);
    }

    public void unlikeComment(LikeRequestDto dto) {
        Comment comment = getComment(dto.targetId());
        User user = userService.getUser(dto.userId());

        //이미 좋아요를 누른 상태면
        if (likeRepository.checkLike(comment, user)) {
            comment.unlike(user);
            likeRepository.unlike(comment, user);
        }
    }


}
