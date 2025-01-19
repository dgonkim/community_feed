package com.community_feed.post.repository;

import com.community_feed.post.application.interfaces.LikeRepository;
import com.community_feed.post.domain.Post;
import com.community_feed.post.domain.comment.Comment;
import com.community_feed.post.repository.entity.comment.CommentEntity;
import com.community_feed.post.repository.entity.like.LikeEntity;
import com.community_feed.post.repository.entity.like.LikeIdEntity;
import com.community_feed.post.repository.jpa.JpaCommentRepository;
import com.community_feed.post.repository.jpa.JpaLikeRepository;
import com.community_feed.post.repository.jpa.JpaPostRepository;
import com.community_feed.user.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
@Transactional
public class LikeRepositoryImpl implements LikeRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    private final JpaLikeRepository jpaLikeRepository;
    private final JpaPostRepository jpaPostRepository;
    private final JpaCommentRepository jpaCommentRepository;

    @Override
    public boolean checkLike(Post post, User user) {
        LikeEntity likeEntity = new LikeEntity(post, user);
        LikeIdEntity id = likeEntity.getId();
        return jpaLikeRepository.existsById(id);
    }

    @Override
    public void like(Post post, User user) {
        LikeEntity likeEntity = new LikeEntity(post, user);
        jpaLikeRepository.save(likeEntity);
        jpaPostRepository.updateLikeCount(post);
    }

    @Override
    public void unlike(Post post, User user) {
        LikeEntity likeEntity = new LikeEntity(post, user);
        jpaLikeRepository.deleteById(likeEntity.getId());
        jpaPostRepository.updateLikeCount(post);
    }

    @Override
    public boolean checkLike(Comment comment, User user) {
        LikeEntity likeEntity = new LikeEntity(comment, user);
        return jpaLikeRepository.existsById(likeEntity.getId());
    }

    @Override
    public void like(Comment comment, User user) {
        LikeEntity likeEntity = new LikeEntity(comment, user);
        entityManager.persist(likeEntity);
//        jpaLikeRepository.save(likeEntity);
        jpaCommentRepository.updateLikeCount(new CommentEntity(comment));
    }

    @Override
    public void unlike(Comment comment, User user) {
        LikeEntity likeEntity = new LikeEntity(comment, user);
        jpaLikeRepository.deleteById(likeEntity.getId());
        jpaCommentRepository.updateLikeCount(new CommentEntity(comment));
    }


//
//    @Override
//    public Post save(Post post) {
//        PostEntity postEntity = new PostEntity(post);
//        postEntity = jpaPostRepository.save(postEntity);
//        return postEntity.toPost();
//    }
//
//    @Override
//    public Post findById(Long id) {
//        PostEntity postEntity = jpaPostRepository.findById(id).orElseThrow(IllegalAccessError::new);
//        return postEntity.toPost();
//    }

}
