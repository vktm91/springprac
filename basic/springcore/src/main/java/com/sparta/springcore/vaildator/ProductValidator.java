package com.sparta.springcore.vaildator;

import com.sparta.springcore.dto.ProductRequestDto;
import org.springframework.stereotype.Component;

@Component   //Bean으로 등록해서 DI받아서 쓸수있게함, 스프링 Bean끼리만 DI를 받을수있다. 그러나 Product Class는 Bean이 아니기때문에 필요할때마다 만들어 써야함
public class ProductValidator {    //Product클래스의 함수를 클래스로 뽑아낸것임!
    public static void validateProductInput(ProductRequestDto requestDto, Long userId) {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("회원 Id 가 유효하지 않습니다.");
        }    //다른곳에서 접근할 수 있도록 접근 제한자를 public으로

        if (requestDto.getTitle() == null || requestDto.getTitle().isEmpty()) {
            throw new IllegalArgumentException("저장할 수 있는 상품명이 없습니다.");
        }

        if (!URLValidator.isValidUrl(requestDto.getImage())) {
            throw new IllegalArgumentException("상품 이미지 URL 포맷이 맞지 않습니다.");
        }   ///isValidUrl 멤버변수였지만, URLValidator로 분리되었으니 클래스추가

        if (!URLValidator.isValidUrl(requestDto.getLink())) {
            throw new IllegalArgumentException("상품 최저가 페이지 URL 포맷이 맞지 않습니다.");
        }

        if (requestDto.getLprice() <= 0) {
            throw new IllegalArgumentException("상품 최저가가 0 이하입니다.");
        }
    }
}