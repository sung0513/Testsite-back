package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Table(name = "orderfood")
public class Orderfood extends BaseTimeEntity {

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
        orderfood.Setting_Food(food);
        orderfood.Total_price(orderprice);
        orderfood.Total_Quantity(count);
        return orderfood;
    }

    public void Setting_Food(Food food){
        this.food = food;
    }

    public void Total_price(int orderprice){
        this.orderprice = orderprice;
    }

    public void Total_Quantity(int count){
        this.count = count;
    }

    public void Recive_Order(Order order){
        this.order = order;
    }

    public void cancel() { //주문중 취소
        getOrder().cancel();
    }


//총가

    public int getTotalPrice() {
        return getOrderprice() * getCount()-getDiscount();
    }


}