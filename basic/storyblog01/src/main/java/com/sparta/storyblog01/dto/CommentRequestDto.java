package com.sparta.storyblog01.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private String username;
    private String contents;
    private String deletecomment;
}
