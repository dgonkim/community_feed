package com.community_feed.post.repository.entity.post;

import com.community_feed.post.domain.content.PostPublicationState;
import jakarta.persistence.AttributeConverter;

public class PostPublicationStateConverter implements AttributeConverter<PostPublicationState, String> {
    @Override
    public String convertToDatabaseColumn(PostPublicationState attribute) {

        return attribute.name();
    }

    @Override
    public PostPublicationState convertToEntityAttribute(String dbData) {
        return PostPublicationState.valueOf(dbData);
    }
}
