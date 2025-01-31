package com.community_feed.post.application;

import com.community_feed.post.application.dto.CreatePostRequestDto;
import com.community_feed.post.application.dto.CreateUserRequestDto;
import com.community_feed.post.application.dto.likePostRequestDto;
import com.community_feed.post.application.interfaces.LikeRepository;
import com.community_feed.post.application.interfaces.PostRepository;
import com.community_feed.post.application.interfaces.UserRepository;
import com.community_feed.post.domain.Post;
import com.community_feed.post.domain.content.Content;
import com.community_feed.post.domain.content.PostContent;
import com.community_feed.user.application.UserService;
import com.community_feed.user.domain.User;
import com.community_feed.user.domain.UserInfo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostService {

    private final UserService userService;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;

    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Post createPost(CreatePostRequestDto dto) {
        User author = userService.getUser(dto.userId());
        Content content = new PostContent(dto.content());
        Post post = new Post(null, author, content, dto.state());
        return postRepository.save(post);
    }

    public Post updatePost(Long id, CreatePostRequestDto dto) {
        Post post = getPost(id);
        User user = userService.getUser(dto.userId());

        post.updatePost(user, dto.content(), dto.state());
        return postRepository.save(post);
    }

    public void likePost(likePostRequestDto dto) {
        Post post = getPost(dto.postId());
        User user = userService.getUser(dto.userId());

        //이미 좋아요를 누른 상태면
        if (likeRepository.checkLike(post, user)) {
            return;
        }

        post.like(user);
        likeRepository.like(post, user);
    }

    public void unlikePost(likePostRequestDto dto) {
        Post post = getPost(dto.postId());
        User user = userService.getUser(dto.userId());

        //이미 좋아요를 누른 상태면
        if (likeRepository.checkLike(post, user)) {
            post.unlike(user);
            likeRepository.unlike(post, user);
        }
    }


}
