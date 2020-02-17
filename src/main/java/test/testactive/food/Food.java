package test.testactive.food;


import lombok.Getter;
import lombok.Setter;
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
public abstract class Food {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 인덱스 ++ 만드는것
    @Column(name = "food_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "foods")
    private List<Category> categories = new ArrayList();

    //==비즈니스 로직== 장바구니//
    public void Stock(int quantity) //+, - 둘다 해당함수 불러옴
    {
        this.stockQuantity += quantity; //취소버튼을 누를경우 -1값이 넘어간다
        if (stockQuantity == 0) {
            throw new NotEnoughStockException("non click sub");
        } else if (stockQuantity >= 100) {
            throw new NotEnoughStockException("non click add");
        }
    }
}