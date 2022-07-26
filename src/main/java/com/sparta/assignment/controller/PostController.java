package com.sparta.assignment.controller;

import com.sparta.assignment.domain.Post;
import com.sparta.assignment.dto.PostRequestDto;
import com.sparta.assignment.repository.PostRepository;
import com.sparta.assignment.service.PostService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        return postRepository.save(post);
    }

    @GetMapping("/api/posts")
    public List<Post> readPosts() {
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @PutMapping("/api/posts/{id}")
    public String updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        return postService.update(id, postRequestDto);
    }

    @DeleteMapping("/api/posts/{id}")
    public String deletePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        return postService.delete(id, postRequestDto);
    }

}
