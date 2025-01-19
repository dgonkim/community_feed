package com.community_feed.post.repository.jpa;

import com.community_feed.post.repository.entity.like.LikeEntity;
import com.community_feed.post.repository.entity.like.LikeIdEntity;
import com.community_feed.post.repository.entity.post.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLikeRepository extends JpaRepository<LikeEntity, LikeIdEntity> {


}
