package test.testactive.domain;


import lombok.Getter;
import lombok.Setter;
import test.testactive.food.Food;

import javax.persistence.*;

@Entity
@Getter@Setter
@Table(name = "orderfood")
public class Orderfood {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderfood_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderprice;

    private int count;

    private  int discount;

    protected Orderfood() {

    }

    //같은 로직만 적용이 되도록 막아놓기 위한 코드임 ->

    public static Orderfood createOrderfood(Food food, int orderprice, int count ) {
        Orderfood orderfood = new Orderfood();
        orderfood.setFood(food);
        orderfood.setOrderprice(orderprice);
        orderfood.setCount(count);
        return orderfood;
    }


    public void cancel() {
        getOrder().Stock(count);
    }

    //총가

    public int getTotalPrice() {
        return getOrderprice() * getCount()-getDiscount();
    }


}