package com.community_feed.post.domain.comment;

import com.community_feed.common.domain.PositiveIntegerCounter;
import com.community_feed.post.domain.Post;
import com.community_feed.post.domain.content.CommentContent;
import com.community_feed.user.domain.User;
import com.community_feed.post.domain.content.Content;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Comment {

    private Long id;
    private Post post;
    private User author;
    private Content content;
    private PositiveIntegerCounter likeCount;

    public static Comment createComment(Post post, User author, String content){
        return new Comment(null, post, author, new CommentContent(content));
    }


    public Comment(Long id, Post post, User author, Content content) {

        if (author == null) {
            throw new IllegalArgumentException();
        }
        if (post == null) {
            throw new IllegalArgumentException();
        }
        if (content == null) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.post = post;
        this.author = author;
        this.content = content;
         this.likeCount = new PositiveIntegerCounter();
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
    public void updateComment(User user, String updateContent) {
        if (!this.author.equals(user)) {
            throw new IllegalArgumentException();
        }

        this.content.updateContent(updateContent);
    }

    public String getContent() {
        return content.getContentText();
    }
}
