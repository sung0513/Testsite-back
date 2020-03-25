package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
public class Store extends BaseTimeEntity {


    //디비에저장
    @Id
    @GeneratedValue
    @Column(name = "storse_id")
    private Long id;

    @Column(name = "store_name")
    private String name;

    @Column(name = "store_tel")
    private String tel;


    @Column(name = "store_address")
    private String address; //가게주소 입력 변경사항 -> address클래스에서 직접 입력하는 변수명으로 바꿈


    @Column(name = "store_coupon")
    private int s_coupon;


    @ManyToOne(fetch = FetchType.LAZY) //member 과 order을 n:1로 매핑시킨다
    @JoinColumn(name = "member_id") //외래키생성. many에서만 생성된다.
    private Member member;


    @Builder //사용자에게 입력받는 정보 + 사용자에게 해당정보를 보여준다.
    public Store(String name, String tel, String address, int s_coupon) {
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.s_coupon = s_coupon;
    }

}
