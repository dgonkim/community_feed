package com.community_feed.post.repository.entity.like;

import com.community_feed.common.repository.entity.TimeBaseEntity;
import com.community_feed.post.domain.Post;
import com.community_feed.post.domain.comment.Comment;
import com.community_feed.user.domain.User;
import com.community_feed.user.repository.UserRelationIdEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "community_like")
@NoArgsConstructor
public class LikeEntity extends TimeBaseEntity {

    @EmbeddedId
    private LikeIdEntity id;

    public LikeEntity(Post post, User likeedUser) {
        this.id = new LikeIdEntity(post.getId(), likeedUser.getId(), LikeTarget.POST.name());
    }

    public LikeEntity(Comment comment, User likedUser) {
        this.id = new LikeIdEntity(comment.getId(), likedUser.getId(), LikeTarget.COMMENT.name());
    }
}
