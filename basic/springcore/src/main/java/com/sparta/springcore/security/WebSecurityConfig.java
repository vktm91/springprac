package com.sparta.springcore.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration   //서버 첫 기동시 설정 역할
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override    //configure 함수는 인증, 인가관련 설정 할 수 있는건데, 기본 설정으로 원래 있는거고 원하는대로 변경하여 사용하기 위해 오버라이드함.
    protected void configure(HttpSecurity http) throws Exception {
                //오른쪽버튼 > go to > suepr method
        http.authorizeRequests()
// 어떤 요청이든 '인증'
                .anyRequest().authenticated()   //and는 조건을 추가하겠다는 의미
                .and()
// 로그인 기능 허용    //미리 스프링 Security에서 만들어놓은 formLogin 기능을 허용
                .formLogin()
                .defaultSuccessUrl("/")   //성공하게되면 이동
                .permitAll()
                .and()
// 로그아웃 기능 허용
                .logout()
                .permitAll();   //인증 못받아도 이거에 대해서는 허용해달라
    }
}