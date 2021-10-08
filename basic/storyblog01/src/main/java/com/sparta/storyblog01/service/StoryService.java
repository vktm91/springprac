package com.sparta.storyblog01.service;

import com.sparta.storyblog01.domain.Story;
import com.sparta.storyblog01.repository.StoryRepository;
import com.sparta.storyblog01.dto.StoryRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class StoryService {

    private final StoryRepository storyRepository;

//    @Autowired
//    public StoryService(StoryRepository storyRepository) {
//        this.storyRepository = storyRepository;
//    }

    public Story create(StoryRequestDto requestDto, String userId) {
        Story story = new Story(requestDto, userId);
        storyRepository.save(story);
        return story;
    }

    @Transactional
    public Long update(Long id, StoryRequestDto requestDto) {
        Story story = storyRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다"));
        story.update(requestDto);
        System.out.println(requestDto);
        return id;
    }
}
