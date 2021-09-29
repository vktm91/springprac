package com.sparta.week04.models;

import lombok.Getter;
import org.json.JSONObject;

@Getter   //생성자를 통해서 정보를 주입받을거기때문에 세터 필요없다.
public class ItemDto {
    private String title;
    private String link;
    private String image;
    private int lprice;

    public ItemDto(JSONObject itemJson) {
        //ItemDto는 내가 가져온 정보를 클라이언트에게 돌려주기위한 도구니까 title, link, image, lprice 정도가 필요하다. 나머진 다 붙여져있음.
        this.title = itemJson.getString("title");
        this.link = itemJson.getString("link");
        this.image = itemJson.getString("image");
        this.lprice = itemJson.getInt("lprice");
    }
}