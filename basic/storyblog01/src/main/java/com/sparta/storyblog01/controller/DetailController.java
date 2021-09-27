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

    @GetMapping("/api/storys/details/{id}")
    public String detail(Model model, @PathVariable Long id) {
        Story testvalue = storyRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다"));
        System.out.println(testvalue);
        model.addAttribute("data", "NICE");
        model.addAttribute("data2", testvalue);
        return "detail";
    }

    @GetMapping("/api/storys/writting")
    public String writtingStory(Model model) {
        model.addAttribute("writting", "writting");
        return "writting";
    }





//    @GetMapping("/valueStory")
//    public Story valueStory(@PathVariable Long id){
//        System.out.println(storyRepository.getById(id).getClass());
//        return storyRepository.getById(id);
//    }
}
