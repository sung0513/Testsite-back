package test.testactive.domain;





import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import test.testactive.food.Food;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter

////주소, 가격, 가게이름
public class Checklist extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "now_id")
    private Long id;


    //현재 주소 2개, zipcode
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "street")
    private Member member;



    //수량 + 배달상태
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_quantity")
    private Order order;


    //가게이름
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "store_name")
    private Store store;


    //name, price
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "food_name")
    private Food food;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "status")
    private Delivery delivery;




    public  static Checklist createchecklist(Member member, Order order, Food food, Store store, Delivery delivery)
    {
        Checklist checklist = new Checklist();
        checklist.SetMember(member);
        checklist.SetOrder(order);
        checklist.SetStore(store);
        checklist.SetDelivery(delivery);
        checklist.SetFood(food);

      return checklist;
    }


    public void SetMember(Member member) {
        this.member = member;
        member.setChecklist(this);
    }

    public void SetOrder(Order order) {
        this.order = order;
        order.setCheklist(this);
    }

    public void SetStore(Store store) {
        this.store = store;
        store.setChecklist(this);
    }

    public void SetDelivery(Delivery delivery) {
        this.delivery= delivery;
        delivery.setChecklist(this);
    }

    public void SetFood(Food food) {
        this.food= food;
        food.setChecklist(this);
    }




//    @Builder // 값변경.
//    public Checklist(String price,String name) {
//        this.price =
//        this.name = name;
//    }

}

//member: member_id, address
//food: name, price
//store : name, tel
//delivery : status
//order : stockquantity
