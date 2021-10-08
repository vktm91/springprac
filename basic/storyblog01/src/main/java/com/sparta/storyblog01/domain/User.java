package com.sparta.storyblog01.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class User {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;   //pk값

    // nullable: null 허용 여부
    // unique: 중복 허용 여부 (false 일때 중복 허용)
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)   //unique 디폴트값은 false이므로 false는 안써줘도됨
    private String password;

//    @Column(nullable = false, unique = true)
//    private String email;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)   //db에 저장될때는 Enum값이 아닌 string으로 저장하겠다는 의미
    private UserRoleEnum role;

    @Column(unique = true)
    private Long kakaoId;


// 일반 폼 회원가입
    public User(String username, String password, UserRoleEnum role) {
        this.username = username;
        this.password = password;
//        this.email = email;
        this.role = role;
        this.kakaoId = null;
    }

    // 카카오 회원가입
    public User(String username, String password, UserRoleEnum role, Long kakaoId) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.kakaoId = kakaoId;
    }
}