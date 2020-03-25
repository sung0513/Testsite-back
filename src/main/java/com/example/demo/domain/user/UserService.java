//package com.example.demo.domain.user;//package test.testactive.domain.user;
//
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.securit.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import test.testactive.repository.MemberRepository;
//
//import org.springframework.security.core.userdetails.User;
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@AllArgsConstructor
//public class UserService implements UserDetailsService {
//    private UserRepository userRepository;
//
//    @Transactional
//    public Long joinUser(UserDto userDto) {
//        // 비밀번호 암호화
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
//
//        return userRepository.save(userDto.toEntity()).getId();
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
//        Optional<test.testactive.domain.user.User> userEntityWrapper = userRepository.findByEmail(userEmail);
//        test.testactive.domain.user.User userEntity = userEntityWrapper.get();
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        if (("tkawnd111@gmail.com").equals(userEmail)) {
//            authorities.add(new SimpleGrantedAuthority(Role.USER.getKey()));
//        } else {
//            authorities.add(new SimpleGrantedAuthority(Role.GUEST.getKey()));
//        }
//
//        return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
//    }
//}
////