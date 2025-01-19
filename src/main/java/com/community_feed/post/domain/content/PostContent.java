package com.community_feed.post.domain.content;

import lombok.Getter;

@Getter
public class PostContent extends Content {


    public static final int POST_MAX_LENGTH = 500;
    public static final int POST_MIN_LENGTH = 0;

    public PostContent(String content) {
        super(content);
    }

    //다형성
    @Override
    protected void checkText(String contentText) {
        if (contentText == null || contentText.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (contentText.length() > POST_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }

        if (contentText.length() < POST_MIN_LENGTH) {
            throw new IllegalArgumentException();
        }



    }


}
