package testbook.testsite.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import testbook.testsite.food.Food;

import javax.persistence.*;

@Entity
@Getter@Setter
@Table(name = "order_food")
public class OrderFood {

    @Id@GeneratedValue
    @Column(name = "order_food_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderprice;

}
