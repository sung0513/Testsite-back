package test.testactive.domain;


import jdk.nashorn.internal.runtime.Debug;
import lombok.*;
import org.springframework.stereotype.Component;
import test.testactive.food.Food;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
//food_name, food_price, store_name, store_tel, my_address, status
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column
    private String name;


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
    public Member(String name, Address address, Coupon coupon) {
        this.name = name;
        this.address = address;
        this.coupon = coupon;

    }




}








// 내정보에서 로그인정보, 주문목록을 보여주는 클래스.
// orderfood에서 정보를 보여주는 클래스
//