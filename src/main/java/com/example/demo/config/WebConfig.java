package com.example.demo.config;


import com.example.demo.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.util.List;

//스프링에서 인식시키기
@RequiredArgsConstructor
@Configuration //어노테이션기반 환경구성을 돕는다.클래스가 하나이상의 bean 메소드를 제공.
public class WebConfig implements WebMvcConfigurer { //handlerMethodArgumentResolver은 항상 WebMvcConfigurer 의 AddArgumentResolvers()를 통해 추가해야한다.
    private final LoginUserArgumentResolver
     loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){
        argumentResolvers.add(loginUserArgumentResolver);
    }
}
