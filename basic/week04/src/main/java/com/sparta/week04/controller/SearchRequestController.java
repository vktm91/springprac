package com.sparta.week04.controller;

import com.sparta.week04.models.ItemDto;
import com.sparta.week04.utils.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor // final 로 선언된 클래스를 자동으로 생성합니다.
@RestController // JSON으로 응답함을 선언합니다.
public class SearchRequestController {

    private final NaverShopSearch naverShopSearch;

    @GetMapping("/api/search")    //물음표부터는 쓰는것 아님! 실제 주소는 ?앞까지!
    public List<ItemDto> getItems(@RequestParam String query) {   //파라미터는 물음표 뒤에오는거, 요청할때 파라마티중에 쿼리가있으면 여기에 넣어줘
        //api/search?query=검색어   =앞에 변수명 같아야함
        String resultString = naverShopSearch.search(query);
        return naverShopSearch.fromJSONtoItems(resultString);
    }
}