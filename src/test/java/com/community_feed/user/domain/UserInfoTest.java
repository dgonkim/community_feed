package com.community_feed.user.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.NamedExecutable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInfoTest {


    @DisplayName("")
    @Test
    public void test01() throws Exception {

        Assertions.assertThrows(IllegalArgumentException.class, (NamedExecutable) () -> new UserInfo("",""));
    }

}