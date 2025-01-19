package com.community_feed.post.repository.jpa;

import com.community_feed.post.domain.Post;
import com.community_feed.post.repository.entity.comment.CommentEntity;
import com.community_feed.post.repository.entity.post.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaCommentRepository extends JpaRepository<CommentEntity, Long> {


    @Modifying
    @Query("UPDATE CommentEntity c "
            + "SET c.content = :#{#comment.getContent()},"
            + "c.updDt = now() "
            + "WHERE c.id = :#{#comment.getId()}")
    void updateCommentEntity(@Param("comment") CommentEntity comment);


    @Modifying
    @Query("UPDATE CommentEntity  c "
            + "SET c.likeCount = :#{#comment.getLikeCount()},"
            + "c.updDt = now() "
            + "WHERE c.id = :#{#comment.getId()}")
    void updateLikeCount(@Param("comment") CommentEntity comment);

}
