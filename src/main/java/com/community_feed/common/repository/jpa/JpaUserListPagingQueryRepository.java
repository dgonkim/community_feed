package com.community_feed.common.repository.jpa;

import com.community_feed.user.application.dto.GetUserListResponseDto;
import com.community_feed.user.repository.QUserEntity;
import com.community_feed.user.repository.QUserRelationEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaUserListPagingQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private static final QUserEntity user = QUserEntity.userEntity;
    private static final QUserRelationEntity relation = QUserRelationEntity.userRelationEntity;

    public List<GetUserListResponseDto> getFollowerList(Long userId, Long lastFollowerId) {
        return jpaQueryFactory
                .select(
                        Projections.fields(
                                GetUserListResponseDto.class,
                                user.name,
                                user.profileImage
                        )
                )
                .from(relation)
                .join(user).on(relation.followingUserId.eq(user.id))
                .where(
                        relation.followerUserId.eq(userId), hasLastData(lastFollowerId)
                )
                .orderBy(user.id.desc())
                .limit(20)
                .fetch();
    }

    private BooleanExpression hasLastData(Long lastId) {
        if (lastId == null) {
            return null;
        }
        return user.id.lt(lastId);
    }


}
