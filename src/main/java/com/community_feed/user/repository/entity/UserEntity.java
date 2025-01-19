package com.community_feed.user.repository.entity;

import com.community_feed.common.domain.PositiveIntegerCounter;
import com.community_feed.common.repository.entity.TimeBaseEntity;
import com.community_feed.user.domain.User;
import com.community_feed.user.domain.UserInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "community_user")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends TimeBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String profileImage;
    private Integer followerCount;
    private Integer followingCount;

//    @OneToMany
//    private List<PostEntity> posts;

    public UserEntity(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.profileImage = user.getProfileImage();
        this.followerCount = user.getFollowerCount();
        this.followingCount = user.getFollowingCount();
    }

    public User toUser(){
        return User.builder()
                .id(id)
                .info(new UserInfo(name, profileImage))
                .followerCount(new PositiveIntegerCounter(followerCount))
                .followingCount(new PositiveIntegerCounter(followingCount))
                .build();
    }

}
