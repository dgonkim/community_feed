package com.community_feed.post.application;

import com.community_feed.post.application.dto.CreatePostRequestDto;
import com.community_feed.post.application.dto.LikeRequestDto;
import com.community_feed.post.application.dto.UpdatePostRequestDto;
import com.community_feed.post.application.interfaces.LikeRepository;
import com.community_feed.post.application.interfaces.PostRepository;
import com.community_feed.post.domain.Post;
import com.community_feed.post.domain.content.Content;
import com.community_feed.post.domain.content.PostContent;
import com.community_feed.user.application.UserService;
import com.community_feed.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final UserService userService;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;

    public Post getPost(Long id) {
        return postRepository.findById(id);
    }

    public Post createPost(CreatePostRequestDto dto) {
        User author = userService.getUser(dto.userId());
        Content content = new PostContent(dto.content());
        Post post = new Post(null, author, content, dto.state());
        return postRepository.save(post);
    }

    @Transactional
    public Post updatePost(Long id, UpdatePostRequestDto dto) {
        Post post = getPost(id);
        User user = userService.getUser(dto.userId());
        post.updatePost(user, dto.content(), dto.state());
        return postRepository.save(post);
    }

    public void likePost(LikeRequestDto dto) {
        Post post = getPost(dto.targetId());
        User user = userService.getUser(dto.userId());

        //이미 좋아요를 누른 상태면
        if (likeRepository.checkLike(post, user)) {
            return;
        }

        post.like(user);
        likeRepository.like(post, user);
    }

    public void unlikePost(LikeRequestDto dto) {
        Post post = getPost(dto.targetId());
        User user = userService.getUser(dto.userId());

        //이미 좋아요를 누른 상태면
        if (likeRepository.checkLike(post, user)) {
            post.unlike(user);
            likeRepository.unlike(post, user);
        }
    }


}
