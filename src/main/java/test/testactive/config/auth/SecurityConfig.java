package test.testactive.config.auth;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.HttpHeaderSecurityFilter;
//import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import test.testactive.domain.user.Role;


@RequiredArgsConstructor
@EnableWebSecurity //error
public class SecurityConfig extends
        WebSecurityEnablerConfiguration {

    private final CustomOauth2UserService customOAuth2UserService;

//    @Override 오류시 컴파일에러를 뜰수있게함.
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .headers().frameOptions().disable() //h2콘솔 화면사용을위해 해당옵션 비활성화
                .and()

                .authorizeRequests()// url별 관리를 설정하는 옵션의 시작점 ; 해당옵션이 실행되어야지 matchers실행 가능

                // '/'등 지정된 url : 전체열람권한 ,
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()//권한관리대상 지정옵션
                //"api/v1/**주소를 가진 api는 user권한을 가진 사람만 등록
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated() //설정된 url이외의 나머지 url들을 나타낸다

                .and()

                .logout()
                .logoutSuccessUrl("/")  //로그아웃 기능에대한 여러설정의 진입점, 성공시 '/'주소로 이동
                .and()
                .oauth2Login() //oauth2로그인 기능에 대한 여러설정의 진입점
                .userInfoEndpoint() // oauth2 로그인 성공 이후 사용자 정보를 가져올때의 설정들을 담당
                .userService(customOAuth2UserService); //소셜로그인 성공시 후속조치를 진행할 usersevice 인터페이스의 구현체 등록
        // 리소스서버(소셜서비스들)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능들을 명시할수 있다.
    }
}
