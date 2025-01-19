package com.community_feed.user.repository.entity;

import com.community_feed.common.repository.entity.TimeBaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "community_user_relation")
@NoArgsConstructor
@AllArgsConstructor
@IdClass(UserRelationIdEntity.class)
public class UserRelationEntity extends TimeBaseEntity {

    //pk를 이용하면 빠른 조회가 가능
    //따로 인덱스를 생성해주지않아도 바로 조회가능

    @Id
    private Long followingUserId;

    @Id
    private Long followerUserId;


}
