package com.sparta.storyblog01.controller;

import com.sparta.storyblog01.domain.Story;
import com.sparta.storyblog01.domain.UserRoleEnum;
import com.sparta.storyblog01.repository.StoryRepository;
import com.sparta.storyblog01.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class DetailController {
    private final StoryRepository storyRepository;


    @GetMapping("/api/storys/details/{id}")
    public String detail(Model model, @PathVariable Long id, Authentication authentication,  @AuthenticationPrincipal UserDetailsImpl userDetails) {

        // 글 상세내용
        Story detailStory = storyRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다"));
        System.out.println(detailStory);
        model.addAttribute("data2", detailStory);


        // 로그인 유저 정보
        if (authentication != null) {
            UserDetails detailUser = (UserDetails) authentication.getPrincipal();
            model.addAttribute("dataUser", detailUser);

            // 로그인 유저 권한
            if (userDetails.getUser().getRole() == UserRoleEnum.ADMIN) {
                model.addAttribute("admin_role", true);
            } else {
                model.addAttribute("admin_role", false);
            }
        }

        return "detail";
    }

    @GetMapping("/api/storys/writting")
    public String writtingStory(Model model, Authentication authentication) {
        model.addAttribute("writting", "writting");

        UserDetails detailUser = (UserDetails) authentication.getPrincipal();
        model.addAttribute("dataUser", detailUser);
        return "writting";
    }

}





//    @GetMapping("/valueStory")
//    public Story valueStory(@PathVariable Long id){
//        System.out.println(storyRepository.getById(id).getClass());
//        return storyRepository.getById(id);
//    }

