package com.community_feed.post.domain;

import com.community_feed.common.domain.PositiveIntegerCounter;
import com.community_feed.post.domain.content.Content;
import com.community_feed.post.domain.content.PostContent;
import com.community_feed.user.domain.User;
import com.community_feed.post.domain.content.PostPublicationState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private  Long id;
    private  User author;
//    private  Long authorId; // 글쓴이
    private  Content content;
    private  PositiveIntegerCounter likeCount;
    //특정 시점의 상태 state (ready 상태-> run 변경되는 경우) ,
    // 일련의 과정 중 결과로서의 상태 status (응답의 결과 http status)
    private PostPublicationState state;

    //정적 생성자 사용
    // 메서드 명으로 알려주기 때문에 유지보수 유리
    public static Post createDefaultPost(Long id, User author, String content, PostPublicationState state) {
        return new Post(id, author, new PostContent(content), PostPublicationState.PUBLIC);
    }

    public static Post createPost(Long id, User author, String content, PostPublicationState state) {
        return new Post(id, author, new PostContent(content), state);
    }

    //생성자 사용
    // 메서드 명으로 어떤 동작을 하는지 알려주기 어려움
    public Post(Long id, User author, Content content) {
        this(id, author, content, PostPublicationState.PUBLIC);
    }

    public Post(Long id, User author, Content content, PostPublicationState state) {
        if (author == null) {
            throw new IllegalArgumentException();
        }

//        t his.author = author;
        this.id = id;
        this.author = author;
        this.content = content;
        this.likeCount = new PositiveIntegerCounter();
//        this.state = PostPublicationState.PUBLIC;
        this.state = state;
    }

    public void like(User user) {
        if (this.author.equals(user)) {
            throw new IllegalArgumentException();
        }
        this.likeCount.increase();
    }

    public void unlike(User user) {
        this.likeCount.decrease();
    }

    //내가 글의 작성자가 아닐경우
    public void updatePost(User user, String updateContent, PostPublicationState state) {
        if (!this.author.equals(user)) {
            throw new IllegalArgumentException();
        }

        this.content.updateContent(updateContent);
        this.state = state;
    }

    public String getContent() {
        return content.getContentText();
    }
}
