package test.testactive.food;


import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.testactive.domain.BaseTimeEntity;
import test.testactive.domain.Category;
import test.testactive.exeception.NotEnoughStockException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Ftype")
@Getter
@Setter
@NoArgsConstructor //생성자 추가
public class Food extends BaseTimeEntity{ //builder로 값을 넘겨줘야함.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 인덱스 ++ 만드는것
    @Column(name = "food_id")
    private Long id;

    private String name;
    private int price;

    @ManyToMany(mappedBy = "foods")
    private List<Category> categories = new ArrayList();

    @Builder // 값변경.
    public Food(String name, int price) {
        this.name = name;
        this.price = price;

    }
}