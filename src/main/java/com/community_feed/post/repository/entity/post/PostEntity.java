package com.community_feed.post.repository.entity.post;

import com.community_feed.common.domain.PositiveIntegerCounter;
import com.community_feed.common.repository.entity.TimeBaseEntity;
import com.community_feed.post.domain.Post;
import com.community_feed.post.domain.content.PostContent;
import com.community_feed.post.domain.content.PostPublicationState;
import com.community_feed.user.repository.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Table(name = "community_post")
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity extends TimeBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //fk 원치않은 인덱스를 걸기도 하고 fk를 설정하지 않는 설정걸기
    @ManyToOne
    @JoinColumn(name = "author_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private UserEntity author;

    private String content;

    @Convert(converter = PostPublicationStateConverter.class)
    private PostPublicationState state;

    private Integer likeCount;

    @ColumnDefault("0")
    private int commentCount;

    public PostEntity(Post post) {
        this.id = post.getId();
        this.author = new UserEntity(post.getAuthor());
        this.content = post.getContent();
        this.state = post.getState();
        this.likeCount = post.getLikeCount().getCount();
    }

    public Post toPost(){
        return Post.builder()
                .id(id)
                .author(author.toUser())
                .content(new PostContent(content))
                .state(state)
                .likeCount(new PositiveIntegerCounter(likeCount))
                .build();
    }




}
