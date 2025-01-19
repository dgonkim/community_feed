package com.community_feed.post.repository.jpa;

import com.community_feed.post.domain.Post;
import com.community_feed.post.repository.entity.post.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaPostRepository extends JpaRepository<PostEntity, Long> {


    @Modifying
    @Query("UPDATE PostEntity p "
            + "SET p.content = :#{#post.getContent()},"
            + "p.state = :#{#post.getState()},"
            + "p.updDt = now() "
            + "WHERE p.id = :#{#post.getId()}")
    void updateEntity(@Param("post") Post post);

    @Modifying
    @Query("UPDATE PostEntity p "
            + "SET p.likeCount = :#{#post.getLikeCount().getCount()},"
            + "p.updDt = now() "
            + "WHERE p.id = :#{#post.getId()}")
    void updateLikeCount(@Param("post") Post post);

    @Modifying
    @Query("UPDATE PostEntity p "
            + "SET p.commentCount = p.commentCount + 1,"
            + "p.updDt = now() "
            + "WHERE p.id = :id")
    void increaseCommentCount(@Param("id") Long id);



}
