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




    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // 쿠폰값 넘김
    private  Coupon coupon;

    @Enumerated(EnumType.STRING) //배달 정보넘김
    private DeliveryStatus status;


    @Builder //사용자에게 입력받는 정보 + 사용자에게 해당정보를 보여준다.
    public Delivery(DeliveryStatus status) {
        this.status = status;
    }


}
