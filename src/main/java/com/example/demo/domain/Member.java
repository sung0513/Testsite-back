package com.example.demo.domain;


import com.example.demo.domain.user.StringCryptoConverter;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.*;

@Entity
@Getter

@NoArgsConstructor
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column
    private String name;

    @Column(name = "member_password")
    @Convert(converter = StringCryptoConverter.class)
    private String password;

    @Column
    private String email;

    @Column
    private String tel;


    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY) //oneToMany ; mappedBy = owner, fetch = 지연로딩
    private List<Order> order = new ArrayList<>();  //member, order을 1:n으로 매핑시키고 order값을 가져온다.


    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Food> food = new ArrayList<>();


    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Store> store = new ArrayList<>();

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Coupon coupon;


    @Builder // 값변경.
    public Member(String name, String email, String tel, String password, Address address, Coupon coupon) {
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.password = password;
        this.address = address;
        this.coupon = coupon;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
