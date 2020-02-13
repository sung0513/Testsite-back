package test.testactive.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter
public class Member {

    @Id@GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @OneToMany(mappedBy = "member", fetch=FetchType.LAZY)
    private Order order;

    private String name;
    @Embedded
    private  Address address;


    @Embedded
    private  Coupon coupon;





}
