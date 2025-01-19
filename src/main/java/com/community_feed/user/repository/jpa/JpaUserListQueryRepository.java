package com.community_feed.user.repository.jpa;

import com.community_feed.user.application.dto.GetUserListResponseDto;
import com.community_feed.user.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaUserListQueryRepository extends JpaRepository<UserEntity, Long> {

    //나를 following하는 user 정보 가져오기
    @Query(value =
            "select new com.community_feed.user.application.dto.GetUserListResponseDto(u.name, u.profileImage) " +
            "from UserRelationEntity ur " +
            "inner join UserEntity  u on ur.followerUserId = u.id " +
            "where ur.followingUserId = :userId")
    List<GetUserListResponseDto> getFollowingUserList(@Param("userId") Long userId);

    //나를 follower 하는 user 정보 가져오기
    @Query(value =
            "select new com.community_feed.user.application.dto.GetUserListResponseDto(u.name, u.profileImage) " +
                    "from UserRelationEntity ur " +
                    "inner join UserEntity  u on ur.followingUserId = u.id " +
                    "where ur.followerUserId = :userId")
    List<GetUserListResponseDto> getFollowerUserList(@Param("userId") Long userId);

}
