package com.sparta.storyblog01.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class SignupRequestDto {

    @NotBlank
    @Length(min=3,message = "닉네임은 최소 3자 이상입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]*$",
            message = "닉네임은 알파벳 대소문자 또는 숫자로만 이루어져있어야 합니다.")
    private String username;


    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp="[a-zA-Z0-9]{6,12}",
            message = "영어와 숫자 포함, 6~12자리 이내로 입력해주세요.")
    private String password;


    @NotBlank(message = "비밀번호 확인은 필수 입력 값입니다.")
    private String passwordCompare;


    @Email(message = "이메일 형식에 맞지 않습니다.")
    private String email;


    private boolean admin = false;

    private String adminToken = "";

}