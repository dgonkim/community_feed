package com.community_feed.user.domain;

import lombok.Getter;

@Getter
public class UserRelationCounter {

    private int count;

    public UserRelationCounter(){
        this.count = 0;
    }

    public void increase(){
        this.count++;
    }
    public void decrease(){
        if (count <= 0) {
            return;
        }
        this.count--;
    }

}
