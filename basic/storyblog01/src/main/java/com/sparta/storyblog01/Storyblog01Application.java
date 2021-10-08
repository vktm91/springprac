package com.sparta.storyblog01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.TimeZone;

@EnableJpaAuditing
@SpringBootApplication
public class Storyblog01Application {

    public static void main(String[] args) {
        SpringApplication.run(Storyblog01Application.class, args);
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }

}
