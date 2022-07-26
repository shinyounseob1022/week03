package com.sparta.assignment.service;

import com.sparta.assignment.domain.Post;
import com.sparta.assignment.dto.PostRequestDto;
import com.sparta.assignment.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public String update(Long id, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        String msg = "";
        if (post.getPassword().equals(postRequestDto.getPassword())) {
            post.update(postRequestDto);
            msg = "게시물이 성공적으로 수정되었습니다.";
        } else {
            msg = "비밀번호가 일치하지 않습니다!";
        }
        System.out.println(msg);
        return msg;
    }

    @Transactional
    public String delete(Long id, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        String msg = "";
        if (post.getPassword().equals(postRequestDto.getPassword())) {
            postRepository.deleteById(id);
            msg = "게시물이 성공적으로 삭제되었습니다.";
        } else {
            msg = "비밀번호가 일치하지 않습니다!";
        }
        System.out.println(msg);
        return msg;
    }

}
