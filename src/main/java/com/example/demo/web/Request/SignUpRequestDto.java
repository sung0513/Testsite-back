package com.example.demo.web.Request;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor

public class SignUpRequestDto {


    @NotBlank
    private String id;


    @NotBlank
    private String password;

    @NotBlank
    private String passwordcheck;


    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String tel;

}
