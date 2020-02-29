package test.testactive.config.auth.dto;
import lombok.Getter;
import test.testactive.domain.user.User;

import java.io.Serializable;

@Getter
//인증된 사용자 정보만 필요하다.
//세션값 저장
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}