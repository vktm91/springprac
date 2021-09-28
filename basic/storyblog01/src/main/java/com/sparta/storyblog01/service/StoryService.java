package com.sparta.storyblog01.service;

import com.sparta.storyblog01.domain.Story;
import com.sparta.storyblog01.domain.StoryRepository;
import com.sparta.storyblog01.domain.StoryRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class StoryService {

    private final StoryRepository storyRepository;

    @Transactional
    public Long update(Long id, StoryRequestDto requestDto) {
        Story story = storyRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다"));
        story.update(requestDto);
        System.out.println(requestDto);
        return id;
    }
}
