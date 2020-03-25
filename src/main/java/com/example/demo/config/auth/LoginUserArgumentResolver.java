package com.example.demo.config.auth;


import com.example.demo.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component //?
//HandlerMethodArgumentResolver 컨트롤러 메서드에서 특정 조건에 맞는 파라미터가 있을 때 원하는 값을 바인딩해주는 인터페이스입니다.
//https://velog.io/@kingcjy/Spring-HandlerMethodArgumentResolver%EC%9D%98-%EC%82%AC%EC%9A%A9%EB%B2%95%EA%B3%BC-%EB%8F%99%EC%9E%91%EC%9B%90%EB%A6%AC
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final HttpSession httpSession;

    @Override
    //지원하는지 판단.
    public boolean supportsParameter(MethodParameter parameter){//컨트롤러 메소드의 특정파라메터를 지원하는지 판단.
       //파라미터에 loginUser어노테이션이 붙어있고 파라미터 클래스타입이 Session.class 인 경우 true 반환
        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class)!=null;

        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType()); //

        return isLoginUserAnnotation && isUserClass;
    }


    @Override
    //수행.
    //파라메터에 전달할 긱체 생성, 세션에서 객체를 가져온다 .
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return httpSession.getAttribute("user");
    }
}
