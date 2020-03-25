package com.example.demo.web.Request;


import com.example.demo.domain.Comments;
import com.example.demo.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class LoginRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @Builder
    public LoginRequestDto(String name, String password) {
        this.name = name;
        this.password = password;

    }

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .password(password)
                .build();
    }
}
