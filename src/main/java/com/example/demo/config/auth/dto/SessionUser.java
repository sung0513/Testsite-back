package com.example.demo.config.auth.dto;
import com.example.demo.domain.BaseTimeEntity;
import com.example.demo.domain.user.User;
import lombok.Getter;


import java.io.Serializable;

@Getter
//인증된 사용자 정보만 필요하다.
//세션값 저장
public class SessionUser extends BaseTimeEntity implements Serializable  {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}