package com.community_feed.post.repository;

import com.community_feed.post.application.interfaces.PostRepository;
import com.community_feed.post.domain.Post;
import com.community_feed.post.repository.entity.post.PostEntity;
import com.community_feed.post.repository.jpa.JpaCommentRepository;
import com.community_feed.post.repository.jpa.JpaPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final JpaPostRepository jpaPostRepository;

    @Override
    @Transactional
    public Post save(Post post) {
        PostEntity postEntity = new PostEntity(post);
        if (post.getId() != null) {
            jpaPostRepository.updateEntity(post);
            return postEntity.toPost();
        }

        postEntity = jpaPostRepository.save(postEntity);
        return postEntity.toPost();
    }

    @Override
    public Post findById(Long id) {
        PostEntity postEntity = jpaPostRepository.findById(id).orElseThrow(IllegalAccessError::new);
        return postEntity.toPost();
    }

}
