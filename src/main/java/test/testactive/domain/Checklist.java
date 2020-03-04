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

    @Column
    private Address street; //member

    @Column
    private String food_name; //음식이름

    @Column
    private int price; //가격

    @Column
    private int stock; //수량

    @Column
    private String store_name; //가게이름

//    @Enumerated(EnumType.STRING) //배달 정보넘김
//    private DeliveryStatus status;




//    //수량 + 배달상태
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "stock_quantity")
//    private Order order;
//
//
//    //가게이름
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "store_name")
//    private Store store;
//
//
//    //name, price
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "food_name")
//    private Food food;
//
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "status")
//    private Delivery delivery;

//
    public  static Checklist createchecklist(Member member, Order order, Food food, Store store)
    {
        Checklist checklist = new Checklist();
//        checklist.SetDelivery(delivery);
//        checklist.SetStore(store);
//        checklist.SetOrder(order);
//        checklist.SetDelivery(delivery);
        checklist.SetAddress(member);
        checklist.SetFoodname(food);
        checklist.SetFoodPrice(food);
        checklist.SetStock(order);
        checklist.SetStorename(store);
//        checklist.SetStatus(delivery);

        return checklist;
    }

//
    public void SetAddress(Member member){
        this.street = member.getAddress();
    }

    public void SetFoodname(Food food){
        this.food_name = food.getName();
    }

    public void SetFoodPrice(Food food){
        this.price = food.getPrice();
    }

    public void SetStock(Order order){
        this.stock= order.getStockQuantity();
    }

    public void SetStorename(Store store){
        this.store_name = store.getName();
    }

//    public void SetStatus(Delivery delivery) {  this.status = delivery.getStatus(); }


    /*
    onetoone불필요
     */

//    public void SetOrder(Order order) {
//        this.order = order;
//        order.setCheklist(this);
//    }
//
//    public void SetStore(Store Store) { //가게의 이름값을 저장한다.
//        this.store = Store;
////        String s = store.getName();
//        store.setChecklist(this);
//    }
//
//    //상태저장
//    public void SetDelivery(Delivery delivery) {
//        this.delivery= delivery;
//        delivery.setChecklist(this);
//    }
//
//    //이름,가격
//    public void SetFood(Food food) {
//        this.food= food;
//        food.setChecklist(this);
//    }




    //2방법
//    @Builder // 값변경.
//    public Checklist(Food food,Member member, Order order, Store store) {
//        this.store_name =store.getName();
//        this.price = food.getPrice();
//        this.street = member.getAddress();
//        this.stock = order.getStockQuantity();
//    }

}

