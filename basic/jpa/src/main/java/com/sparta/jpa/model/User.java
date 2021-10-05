package com.sparta.jpa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class User {
    // nullable: null 허용 여부
// unique: 중복 허용 여부 (false 일때 중복 허용)
    @Id   //이 부분이 id로 지금 사용되고있다 pk다
    @Column(name = "id", nullable = false, unique = true)   //자바객체에서는 username 테이블에서는 id라는 이름
    private String username;

    @Column(nullable = false, unique = false)
    private String nickname;

    @Column(nullable = false, unique = false)
    private String favoriteFood;

    public User(String username, String nickname, String favoriteFood) {
        this.username = username;
        this.nickname = nickname;
        this.favoriteFood = favoriteFood;
    }
}