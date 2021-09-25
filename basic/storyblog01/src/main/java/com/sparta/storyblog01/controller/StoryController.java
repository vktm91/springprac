package com.sparta.storyblog01.controller;

import com.sparta.storyblog01.domain.Story;
import com.sparta.storyblog01.domain.StoryRepository;
import com.sparta.storyblog01.domain.StoryRequestDto;
import com.sparta.storyblog01.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StoryController {
    private final StoryRepository storyRepository;
    private final StoryService storyService;


    @PostMapping("/api/storys")
    public Story createStory(@RequestBody StoryRequestDto requestDto) {
        Story story = new Story(requestDto);
        return storyRepository.save(story);
    }

    @GetMapping("/api/storys")
    public List<Story> readStorys() {
        return  storyRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/storys/{id}")
    public Long deleteStory(@PathVariable Long id) {
        storyRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/storys/{id}")
    public Long updateStory(@PathVariable Long id, @RequestBody StoryRequestDto requestDto) {
        storyService.update(id, requestDto);
        return id;
    }

}