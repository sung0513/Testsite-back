package test.testactive.config.auth.dto;

//DTO
import lombok.Builder;
import lombok.Getter;
import test.testactive.domain.user.Role;
import test.testactive.domain.user.User;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }


    // of() OAuth2User에서 반환하는 사용자 정보는 Map이기 때문에 값 하나하나를 변환해야 한다.
    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }


    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    //toEntity
    //User엔티티생성, OAuthAttributes에서 엔티티를 생성하는 시점은 처음 가입할때 이다.
    //가입할때의 기본권한을 GUEST로 주기위해서 role빌더값에는 Role.GUEST를 사용한다.
    //해당클래스 생성후 sessionuser 클래스생성
    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST) //가입시 기본권한
                .build();
    }
}