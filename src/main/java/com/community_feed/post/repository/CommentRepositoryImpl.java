package com.community_feed.post.repository;

import com.community_feed.post.application.interfaces.CommentRepository;
import com.community_feed.post.application.interfaces.LikeRepository;
import com.community_feed.post.domain.Post;
import com.community_feed.post.domain.comment.Comment;
import com.community_feed.post.repository.entity.comment.CommentEntity;
import com.community_feed.post.repository.jpa.JpaCommentRepository;
import com.community_feed.post.repository.jpa.JpaLikeRepository;
import com.community_feed.post.repository.jpa.JpaPostRepository;
import com.community_feed.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {

    private final JpaCommentRepository jpaCommentRepository;
    private final JpaPostRepository jpaPostRepository;


    @Override
    @Transactional
    public Comment save(Comment comment) {

        CommentEntity commentEntity = new CommentEntity(comment);
        //update
        if (commentEntity.getId() != null) {
            jpaCommentRepository.updateCommentEntity(commentEntity);
            return comment;
        }

        commentEntity = jpaCommentRepository.save(commentEntity);
        //post에 댓글 생성시 마다 commentCount 1씩 증가
        jpaPostRepository.increaseCommentCount(comment.getPost().getId());
        return commentEntity.toComment();
    }

    @Override
    public Comment findById(Long id) {
        CommentEntity commentEntity = jpaCommentRepository.findById(id).orElseThrow(IllegalAccessError::new);
        return commentEntity.toComment();
    }

}
