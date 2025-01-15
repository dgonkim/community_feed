package com.community_feed.user.application.interfaces;

import com.community_feed.user.domain.User;

//user repository 에 follow와 follow를 저장하는 기능을 분리해야할까?
//각각 어떤 장점이 있을까?
//나중에 따로 follow 저장 데이터를 다른 데이터베이스르 옮긴다고 하면 유저레파지토리를 변경해야함
// 그러면 인터페이스가 분리가 된다..
//이렇게 인터페이스를 분리하는게 추후에 더 도움이 될 것 같다.
public interface UserRepository {

    User save(User user);

}
