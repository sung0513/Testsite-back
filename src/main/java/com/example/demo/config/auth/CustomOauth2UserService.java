package com.example.demo.config.auth;


import com.example.demo.config.auth.dto.OAuthAttributes;
import com.example.demo.config.auth.dto.SessionUser;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@RequiredArgsConstructor
@Service //Dao가 DB에서 받아온 데이터를 전달받아 가공한다.
//로그인 이후 가져온 사용자 정보들을 기반으로 가입 및 정보수정, 세션저장등의 기능을 지원
public class CustomOauth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;
    private final HttpSession httpSession; //사용자의정보를 보관, 수정, 세션쿠키를 사용한다
    //https://doublesprogramming.tistory.com/211
    //사용자가 열쇠에해당하는 세션쿠키를 가지고 접근, 서버의 내부에 객체 보관.

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest){
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.
                loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId(); //registrationid: 현재 로그인 진행중인 서비스를 구분하는 코드, 네이버,구글,카카오 구분해준다
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().
                getUserNameAttributeName(); //getUserNameAttributeName: oauth2로그인 진행시 키가되는 필드값들을 의미한다.

        OAuthAttributes attributes = OAuthAttributes.of(registrationId,

                userNameAttributeName, oAuth2User.getAttributes()); // OAuthAttributes : OAuth2UserService를 통해 가져온 OAuth2User의 attribute를 담은 클래스이다.
//jwt 이용해보쟝 ㅋㅋ 정보넘기기. ㅎㅋㅎㅋ jwt = json web tocken



        User user = saveOrUpdate(attributes);
        httpSession.setAttribute("user", new SessionUser(user)); // 세션에 사용자 정보를 저장하기위한 dto클래스이다 user클래스 사용 x

        //유저정보반환
        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());

    }

//필터기반?
    private User saveOrUpdate(OAuthAttributes attributes) { //User 에 저장.
        User user = userRepository.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
                .orElse(attributes.toEntity());

        return userRepository.save(user);
    }

}