package com.example.demo.web.Request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequestDto {

    @NotBlank
    private String id;

    @NotBlank
    private String password;

}
