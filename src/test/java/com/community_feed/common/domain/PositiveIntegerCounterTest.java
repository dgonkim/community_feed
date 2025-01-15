package com.community_feed.common.domain;

import com.community_feed.user.domain.User;
import com.community_feed.user.domain.UserInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PositiveIntegerCounterTest {

    User user1 = null;
    User user2 = null;
    User user3 = null;

    //test 생성시 새로 객체가 생기는 걸 보장해라
    @BeforeEach
    void init(){
        UserInfo userInfo = new UserInfo("test", "");
        user1 = new User(1L, userInfo);
        user2 = new User(2L, userInfo);
        user3 = new User(1L, userInfo);
    }

    @DisplayName("")
    @Test
    public void test01() throws Exception {

        //given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();

        //when
        counter.decrease();

        //then
        assertEquals(0,counter.getCount());

    }

    @DisplayName("equalsAndHashCode 사용해야하는 이유")
    @Test
    public void test02() throws Exception {


        int hashCode1 = user1.hashCode();
        int hashCode2 = user3.hashCode();

        assertNotEquals(hashCode1, hashCode2);

        //when
//        boolean value = user1.equals(user3);
        //then
//        assertTrue(value);
    }

    @DisplayName("follow 검증")
    @Test
    public void follow() throws Exception {

    }



}