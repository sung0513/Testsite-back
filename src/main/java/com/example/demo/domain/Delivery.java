package com.example.demo.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter

@NoArgsConstructor
@Table(name="delivery")
public class Delivery extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private  Long id;

    @OneToOne(mappedBy = "delivery") //mappedby : n:n 매핑시에 owner이 누군지 알려준다.
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // 쿠폰값 넘김
    private  Coupon coupon;

    @Enumerated(EnumType.STRING) //배달 정보넘김
    private DeliveryStatus status;

    public void DeliverySetOrder(Order order){
        this.order = order;
    }

    public void DeliverySetAddress_InOrder(Address address){
        this.address = address;
    }

    @Builder
    public Delivery(Address address, Coupon coupon, DeliveryStatus status) {
        this.address = address;
        this.coupon = coupon;
        this.status = status;

    }
}
