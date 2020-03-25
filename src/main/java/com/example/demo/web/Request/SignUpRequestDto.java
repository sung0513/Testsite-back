package com.example.demo.web.Request;


import com.example.demo.domain.Comments;
import com.example.demo.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor

public class SignUpRequestDto {


    @NotBlank
    private String name;


    @NotBlank
    private String password;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String tel;

    @Builder
    public SignUpRequestDto(String name, String password, String email, String tel) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.tel = tel;
    }

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .password(password)
                .email(email)
                .tel(tel)
                .build();
    }

}
