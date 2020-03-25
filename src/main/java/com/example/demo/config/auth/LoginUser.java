package com.example.demo.config.auth;


//메소드 인자로 세션값을 가져오기

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 해당어노테이션이 생성될수있는 위치를 지정한다.
                                // 파라메터로 지정했으니 메소드의 파라미터로 선언된 객체에만 사용가능
                                // 이외에도 클래스 선언문에 쓸 수있는 type등이 있다.
@Retention(RetentionPolicy.RUNTIME)// 어노테이션범위 : 컴파일이후에도 jvm에서 참조가능
public @interface LoginUser { //해당파일을 어노테이션으로 만들어준다. LoginUser라는 이름을 가진 어노테이션이 생성됨.

}
