package test.testactive.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter
@RequiredArgsConstructor
public class Delivery extends BaseTimeEntity {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private  Long id;

    @OneToOne(mappedBy = "delivery") //mappedby : n:n 매핑시에 owner이 누군지 알려준다.
    private Order order;


//    @OneToOne(mappedBy = "delivery")
//    private Checklist checklist;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // 쿠폰값 넘김
    private  Coupon coupon;

    @Enumerated(EnumType.STRING) //배달 정보넘김
    private DeliveryStatus status;


    @Builder //해당 빌더 문제다.
    public Delivery(DeliveryStatus status, Coupon coupon) {
        this.status = status;
        this.coupon = coupon;
    }


}
