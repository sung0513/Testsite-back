package test.testactive.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter

@Setter
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

}
