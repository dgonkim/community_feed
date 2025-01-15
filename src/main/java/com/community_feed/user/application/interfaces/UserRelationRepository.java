package com.community_feed.user.application.interfaces;

import com.community_feed.user.domain.User;

//여기서 user id를 넘기지 않고 User 전체를 넘기는 이유는 무엇일까?
// user들의 count를 따로 가져와야하는데 그럴필요 없이 객체로 넘기면 편하기 때문에
public interface UserRelationRepository {

    boolean isAlreadyFollow(User user, User targetUser);
    void save(User user, User targetUser);
    void delete(User user, User targetUser);


}
