package com.sparta.week04.utils;

import com.sparta.week04.models.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class NaverShopSearch {
    public String search(String query) {      //ARC COPY 복붙

        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "ivigpNG_r8eKs2s4cQO2");
        headers.add("X-Naver-Client-Secret", "hGQLScOVS_");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);   //body안에 응답받은 결과가 들어간다
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=query", HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();   //200같은게 status에 들어감
        int status = httpStatus.value();
        String response = responseEntity.getBody();   //결과화면이 response로 들어감
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response; //결과값이 response에 들어있으니까

    }


    //문자열로 받고 JSONObject로 바꿔서 ItemDtoList 만들고 반환하는 이 과정은 검색할때마다 이루어지는 것이므로 메소드로 뺀다!
    public List<ItemDto> fromJSONtoItems(String  result) {
        JSONObject rjson = new JSONObject(result);
        JSONArray items = rjson.getJSONArray("items");   //JSONObject, getJSONArray에 특징적으로 들어가는게 get을 쓴다음에 꺼내는 녀석의 자료형을 써준다.

        List<ItemDto> itemDtoList = new ArrayList<>();   // 여기 itemDtoList안에 ItemDto를 하나하나 넣어주고 마지막으로 컨트롤러에서 반환하게됨

        for (int i=0; i<items.length(); i++) {   //JSONArray에서는 size아닌 length로 꺼낸다
            JSONObject itemJson = (JSONObject) items.getJSONObject(i);   //JSONArray에서 꺼내지는 것은 JSONObject, JSONArray인 items에서 .get()으로 꺼낸다.
            ItemDto itemDto = new ItemDto(itemJson);   //itemJson이 만들어둔 itemDto로 흡수!
            itemDtoList.add(itemDto);

        }

        return itemDtoList;

    }

//    public static void main(String[] args) {     //메인메소드 더이상 필요없으니까 지운다
//        NaverShopSearch naverShopSearch = new NaverShopSearch();
//        String result = naverShopSearch.search("아이맥");
//    }
}

//            System.out.println(itemJson);
//                    String title = itemJson.getString("title"); //마찬가지로 get을 쓴다음에 꺼내는 녀석의 자료형 써줌.
//                    String image = itemJson.getString("image");
//                    int lprice = itemJson.getInt("lprice");
//                    String link = itemJson.getString("link");