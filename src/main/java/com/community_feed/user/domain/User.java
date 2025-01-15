package com.community_feed.user.domain;

import com.community_feed.common.domain.PositiveIntegerCounter;
import lombok.Getter;

import java.util.Objects;

@Getter
public class User {

    private final Long id;
    private final UserInfo info;
    private final PositiveIntegerCounter followingCount;
    private final PositiveIntegerCounter followerCount;

    public User(Long id, UserInfo userInfo) {
        this.id = id;
        this.info = userInfo;
        this.followingCount = new PositiveIntegerCounter();
        this.followerCount = new PositiveIntegerCounter();
    }

    public void follow(User targetUser) {
        if (targetUser.equals(this)) {
            throw new IllegalArgumentException();
        }

        followingCount.increase(); //following count 증가
        targetUser.increaseFollowerCount(); //나를 따르는 user의 followerCount 증가
    }

    public void unfollow(User targetUser) {
        if (this.equals(targetUser)) {
            throw new IllegalArgumentException();
        }
        followingCount.decrease(); //following count 증가
        targetUser.decreaseFollowerCount(); //나를 따르는 user의 followerCount 증가
    }

    //해당 함수들은 외부로 노출할 필요가 없으므로 private 선언 -> 구지?
    // 캡슐화를 깨트릴 수 있다는데 -> 구지?
    private void increaseFollowerCount(){
        followerCount.increase();
    }

    private void decreaseFollowerCount(){
        followerCount.decrease();
    }


    /*
    현재 id값으로 객체를 구분해야한다.
    hascode를 오버라이딩해서 등록해 줘야한다.
    지금 상태라면 equal (메모리 주소값)으로 동일시 하기 때문에
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }

}
