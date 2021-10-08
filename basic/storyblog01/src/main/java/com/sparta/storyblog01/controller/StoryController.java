package com.sparta.storyblog01.controller;

import com.sparta.storyblog01.domain.Comment;
import com.sparta.storyblog01.domain.Story;
import com.sparta.storyblog01.dto.CommentRequestDto;
import com.sparta.storyblog01.repository.CommentRepository;
import com.sparta.storyblog01.repository.StoryRepository;
import com.sparta.storyblog01.dto.StoryRequestDto;
import com.sparta.storyblog01.security.UserDetailsImpl;
import com.sparta.storyblog01.service.CommentService;
import com.sparta.storyblog01.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StoryController {
    private final StoryRepository storyRepository;
    private final CommentRepository commentRepository;
    private final StoryService storyService;
    private final CommentService commentService;


    @GetMapping("/api/storys")
    public List<Story> readStory() {
        return storyRepository.findAllByOrderByModifiedAtDesc();
    }

    @PostMapping("/api/storys/writting")
    public Story createStory(@RequestBody StoryRequestDto requestDto,
                             @AuthenticationPrincipal UserDetailsImpl userDetails) {
        String userId = userDetails.getUser().getUsername();
        Story story = storyService.create(requestDto, userId);
        return story;
    }

    @PostMapping("/api/storys/writtingcomment/{id}")
    public Comment createComment(@RequestBody CommentRequestDto requestDto,
                               @AuthenticationPrincipal UserDetailsImpl userDetails,
                                 @PathVariable Long id) {
        String username = userDetails.getUser().getUsername();
        Comment comment = commentService.create(requestDto, id);
        return comment;
    }

    @DeleteMapping("/api/storys/{id}")
    public Long deleteStory(@PathVariable Long id) {
        storyRepository.deleteById(id);
        return id;
    }

    @DeleteMapping("/api/storys/comments/{id}/{id2}")
    public Long deleteComment(@PathVariable Long id, @PathVariable Long id2) {
        System.out.println(" 아이디.겟클래스 " + id.getClass());
        commentService.delete(id, id2);
        return id;
    }

    @PutMapping("/api/storys/{id}")
    public Long updateStory(@PathVariable Long id, @RequestBody StoryRequestDto requestDto) {
        storyService.update(id, requestDto);
        System.out.println(id +" , "+requestDto);
        return id;
    }


//    @PutMapping("/api/storys/comments/{id}")
//    public Long deleteComment(@PathVariable Long id, @RequestBody StoryRequestDto requestDto) {
//        commentService.update()
//    }
}