package com.sparta.storyblog01.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.storyblog01.dto.SignupRequestDto;
import com.sparta.storyblog01.service.KakaoUserService;
import com.sparta.storyblog01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class UserController {

    private final UserService userService;
    private final KakaoUserService kakaoUserService;


    @Autowired   //DI를 받는 부분!!!
    public UserController(UserService userService, KakaoUserService kakaoUserService) {   //UserService를 DI받고
        this.userService = userService;    //그 UserService를 멤버변수로 선언
        this.kakaoUserService = kakaoUserService;
    }

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(@Valid SignupRequestDto requestDto, Errors errors, Model model) {  //valid 어노테이션이 SignupRequestDto를 검증해줘

        String sameUserError = userService.sameUser(requestDto);
        if (sameUserError != null) {
            model.addAttribute("sameUserError", sameUserError);
            model.addAttribute("requestDto", requestDto);
            return "signup";
        }


        if (!requestDto.getPassword().equals(requestDto.getPasswordCompare())) {
            model.addAttribute("requestDto", requestDto);
            model.addAttribute("samePasswordError", "비밀번호를 확인해주세요");
            return "signup";
        }

        if (errors.hasErrors()) {
            // 회원가입 실패시, 입력 데이터를 유지
            model.addAttribute("requestDto", requestDto);

            // 유효성 통과 못한 필드와 메시지를 핸들링
            Map<String, String> validatorResult = userService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }

            return "signup";
        }

        userService.registerUser(requestDto);
        return "redirect:/user/login";

    }

    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
        kakaoUserService.kakaoLogin(code);
        return "redirect:/";
    }
}