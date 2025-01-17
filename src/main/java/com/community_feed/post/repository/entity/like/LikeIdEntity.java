package com.community_feed.post.repository.entity.like;

import com.community_feed.common.repository.entity.TimeBaseEntity;
import com.community_feed.user.repository.UserRelationIdEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class LikeIdEntity implements Serializable {

    private Long targetId;
    private Long userId;
    private String targetType;

}
