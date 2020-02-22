package test.testactive.domain.user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@Getter
@RequiredArgsConstructor// 초기화 되지 않은 final 필드와 @NonNull 어노테이션이 붙은 필드에 대한 생성자 생성
//@AllArgsConstructor //모든필드에 생성자 생성

public enum Role { //해당오류
    //@RequiredArgsConstructor 어노테이션에 의해 만들어짐 생성자가생성됨
    GUEST("ROLE_GUEST", "손님"), //스프링 시큐리티 권한코드에는 항상 ROLE가 있어야한다.
    USER("ROLE_USER", "관리자");

    private final String key;
    private final String title;
}
