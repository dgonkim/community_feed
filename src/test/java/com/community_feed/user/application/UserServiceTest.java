package com.community_feed.user.application;

import com.community_feed.post.application.interfaces.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    //가짜로 mock을 주입해야함
    private final UserRepository userRepository = new FakeUserRepository();
    private final UserService userService = new UserService(userRepository);

    @DisplayName("")
    @Test
    public void test01() throws Exception {

    }



}