package com.community_feed.post.repository.entity.comment;

import com.community_feed.common.domain.PositiveIntegerCounter;
import com.community_feed.common.repository.entity.TimeBaseEntity;
import com.community_feed.post.domain.comment.Comment;
import com.community_feed.post.domain.content.CommentContent;
import com.community_feed.user.repository.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "community_comment")
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity extends TimeBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //fk 원치않은 인덱스를 걸기도 하고 fk를 설정하지 않는 설정걸기
    @ManyToOne
    @JoinColumn(name = "author_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private UserEntity author;

    @ManyToOne
    @JoinColumn(name = "comment_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private CommentEntity comment;

    private String content;
    private Integer likeCount;

    public CommentEntity(Comment comment) {
        this.id = comment.getId();
        this.author = new UserEntity(comment.getAuthor());
        this.content = comment.getContent();
        this.likeCount = comment.getLikeCount().getCount();
    }

    public Comment toComment(){
        return Comment.builder()
                .id(id)
                .author(author.toUser())
                .content(new CommentContent(content))
                .likeCount(new PositiveIntegerCounter(likeCount))
                .build();
    }

}
