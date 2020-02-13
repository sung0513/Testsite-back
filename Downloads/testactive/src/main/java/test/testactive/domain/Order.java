package test.testactive.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
public class Order {

    @Id@GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_order_id")
    private Member member;

    @OneToMany(mappedBy = "orderfood")
    private List<Orderfood> orderfoods = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime totaltime;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

}
