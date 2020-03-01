package test.testactive.domain;





import lombok.Getter;
import lombok.Setter;
import test.testactive.food.Food;


import javax.persistence.*;
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
    private long id;


    //현재 주소 2개
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "street")
//    @JoinColumn(name = "zipcode")
    private Member member;

    //수량
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_quantity")
    private Order order;

    //배달상태
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "status")
    private Delivery delivery;

    //가게정보

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "store_tel")
    @JoinColumn(name = "store_name")
    private Store store;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "price")
    private Food food;





    public void SetMember(Member member) {
        this.member = member;
        member.setChecklist(this);
    }

    public void SetOrder(Order order) {
        this.order = order;
        order.setCheklist(this);
    }

    public void SetDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setChecklist(this);
    }

    public void SetStore(Store store) {
        this.store = store;
        store.setChecklist(this);
    }


    public void SetFoodprice(Food food) {
        this.food = food;
        food.setChecklist(this);
    }




}

//member: member_id, address
//food: name, price
//store : name, tel
//delivery : status
//order : stockquantity
