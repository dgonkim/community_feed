package com.community_feed.post.application.dto;

import lombok.Getter;

//아래와 같이 getter만 가지 객체들은 record로 변환하면 좋다
public record CreateUserRequestDto(String name, String profileImageUrl) {

}
