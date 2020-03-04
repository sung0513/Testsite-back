package test.testactive.food;


import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;
import test.testactive.domain.*;
import test.testactive.exeception.NotEnoughStockException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Ftype")
@Getter
@Setter
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


    @OneToOne(mappedBy = "delivery")
    private Checklist checklist;

    @Builder // 값변경.
    public Food(Long id,String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}