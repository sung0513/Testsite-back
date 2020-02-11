package testbook.testsite.domain;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.criterion.Order;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
public class Member {


        @Id@GeneratedValue
        @Column(name = "member_id")
        private  Long id;

        private  String name;


        private  String key;

        @Embedded
        private  Address address;

        @Embedded
        private  Coupon coupon;

        @OneToOne(mappedBy = "memmber")
        private List<Order> orders = new ArrayList<>();



}

