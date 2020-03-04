package test.testactive.domain;





import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import test.testactive.food.Food;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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


    //가게정보
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "store_tel")
    @JoinColumn(name = "store_name")
    private Store store;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "price")

    private Food food;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "status")
    private Delivery delivery;




    public  static Checklist createchecklist(Member member, Order order, Store store,Food food,Delivery delivery)
    {
        Checklist checklist = new Checklist();
        checklist.SetMember(member);

        checklist.SetOrder(order);
        checklist.SetMember(member);
        checklist.SetFoodprice(food);
        checklist.SetStore(store);
        checklist.SetDelivery(delivery);


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


    public void SetFoodprice(Food food) {
        this.food = food;
        food.setChecklist(this);
    }

    public void SetDelivery(Delivery delivery) {
        this.delivery= delivery;
        delivery.setChecklist(this);
    }
}

//member: member_id, address
//food: name, price
//store : name, tel
//delivery : status
//order : stockquantity
