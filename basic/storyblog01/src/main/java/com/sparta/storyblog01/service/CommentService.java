package com.sparta.storyblog01.service;

import com.sparta.storyblog01.domain.Comment;
import com.sparta.storyblog01.domain.Story;
import com.sparta.storyblog01.dto.CommentRequestDto;
import com.sparta.storyblog01.repository.CommentRepository;
import com.sparta.storyblog01.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final StoryRepository storyRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public Comment create(CommentRequestDto requestDto, Long storyId) {
        Comment comment = new Comment(requestDto);
        Story story = storyRepository.findById(storyId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다"));
        commentRepository.save(comment);
        story.getCommentList().add(comment);
        storyRepository.save(story);
        return comment;
    }

    @Transactional
    public void delete(Long commentId, Long storyId) {

        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다"));;
        Story story = storyRepository.findById(storyId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다"));

        boolean flag = story.getCommentList().remove(comment);
        commentRepository.delete(comment);
        System.out.println(flag);
        storyRepository.save(story);
    }
}
