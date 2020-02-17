package test.testactive.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Getter@Setter
public class Store {


    @Id@GeneratedValue
    @Column(name = "store_id")
    private Long id;

    @Column(name = "store_name")
    private String name;

    @Column(name = "store_tel")
    private int tel;

    @Column(name = "store_category")
    private String category;

    @Embedded
    private Address address;

    @Column(name = "store_coupon")
    private int s_coupon;

}
