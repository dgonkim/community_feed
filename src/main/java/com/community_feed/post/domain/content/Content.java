package com.community_feed.post.domain.content;

import com.community_feed.post.common.DateTimeInfo;

public abstract class Content {

    String contentText;
    final DateTimeInfo dateTimeInfo;

    public Content(String content) {
        checkText(content);
        this.contentText = content;
        this.dateTimeInfo = new DateTimeInfo();
    }

    protected abstract void checkText(String contentText);

    public String getContentText() {
        return contentText;
    }

    public void updateContent(String updateContent) {
        checkText(updateContent);
        this.contentText = updateContent;
        this.dateTimeInfo.updateEditDateTime();
    }

}


