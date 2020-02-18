package test.testactive.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long id;
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Order> order = new ArrayList<>();
    private String name;
    @Embedded
    private Address address;
    @Embedded
    private Coupon coupon;

}

