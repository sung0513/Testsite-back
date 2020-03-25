package com.example.demo.domain;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Ftype")
@Getter
@NoArgsConstructor
@Embeddable
public class Food extends BaseTimeEntity{ //builder로 값을 넘겨줘야함.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 인덱스 ++ 만드는것
    @Column(name = "food_id")
    private Long id;

    private String name;
    private int price;

    @ManyToMany(mappedBy = "foods")
    private List<Category> categories = new ArrayList();

    @ManyToOne(fetch = FetchType.LAZY) //member 과 order을 n:1로 매핑시킨다
    @JoinColumn(name = "member_id") //외래키생성. many에서만 생성된다.
    private Member member;


    @ManyToOne(fetch = FetchType.LAZY) //member 과 order을 n:1로 매핑시킨다
    @JoinColumn(name = "order_id") //외래키생성. many에서만 생성된다.
    private Order order;


    @Builder // 값변경.
    public Food(String name, int price) {
        this.name = name;
        this.price = price;
        setMember(member);
    }

    public void setMember(Member member) {
        this.member = member;
        member.getFood().add(this); //값 상속
    }


}
