package com.sparta.storyblog01.controller;


import com.sparta.storyblog01.domain.Story;
import com.sparta.storyblog01.domain.StoryRepository;
import com.sparta.storyblog01.domain.StoryRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class DetailController {
    private final StoryRepository storyRepository;

    @PostMapping("/api/storys")
    public Story createStory(@RequestBody StoryRequestDto requestDto) {
        Story story = new Story(requestDto);
        return storyRepository.save(story);
    }

    @GetMapping("/api/storys/details")
    public String detail(Model model) {
        model.addAttribute("data", "NICE");
        return  "hello";
    }

}
