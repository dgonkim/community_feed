package com.community_feed.post.domain.content;

public class CommentContent extends Content{

    public static final int POST_MAX_LENGTH = 500;
    public static final int POST_MIN_LENGTH = 5;

    public CommentContent(String content) {
        super(content);
    }

    @Override
    protected void checkText(String contentText) {
        if (contentText == null || contentText.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (contentText.length() > POST_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }

        if (contentText.length() > POST_MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

}
