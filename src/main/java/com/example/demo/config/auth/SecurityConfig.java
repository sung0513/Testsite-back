package com.example.demo.config.auth;
/*
해당 클래스 역할
1. 스프링 시큐리티 활성화
2. x-frame-options 비활성화
3. URL별 권한관리
4. 로그인 , 로그아웃시 구현체 명시
 */

import com.example.demo.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


//    @SuppressWarnings("deprecation")
//    @Bean
//    public static NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }
    private final CustomOauth2UserService customOauth2UserService;


   @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                //시큐리티 x-frame-options 응답헤더, 클릭잭킹
                //https://www.keycdn.com/blog/x-frame-options
                .csrf().disable()
                .headers().frameOptions().disable() //h2콘솔 화면사용을위해 해당옵션 비활성화
                .and()

                .authorizeRequests()// url별 관리를 설정하는 옵션의 시작점 ; 해당옵션이 실행되어야지 matchers실행 가능

                // '/'등 지정된 url : 전체열람권한 ,
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile","/Guest/**").permitAll()//권한관리대상 지정옵션
//               //코멘트 부분 권한
//                .antMatchers("/Guest/**").hasRole(Role.GUEST.name())//Test코드시에 주석처리
                .antMatchers("/Chairman/**").hasRole(Role.USER.name())
                .antMatchers("/post/chairman").hasRole(Role.USER.name())
                .anyRequest().authenticated() //설정된 url이외의 나머지 url들을 나타낸다

                .and()
                    .logout()
                    .logoutSuccessUrl("/")  //로그아웃 기능에대한 여러설정의 진입점, 성공시 '/'주소로 이동
//                    .invalidateHttpSession(true)
                .and()
                //네이버 구글
                    .oauth2Login() //oauth2로그인 기능에 대한 여러설정의 진입점
                        .userInfoEndpoint() // oauth2 로그인 성공 이후 사용자 정보를 가져올때의 설정들을 담당
                             .userService(customOauth2UserService); //소셜로그인 성공시 후속조치를 진행할 usersevice 인터페이스의 구현체 등록
        // 리소스서버(소셜서비스들)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능들을 명시할수 있다.

    }
}





//네이버 카카오 추가