package test.testactive.domain;





import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.testactive.food.Food;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
////주소, 가격, 가게이름
public class Checklist extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checklist_id")
    private Long id;

    @Embedded
    private Address address;

    @Column
    private String food_name; //음식이름

    @Column
    private int price; //가격

    @Column
    private int stock; //수량

    @Column
    private String store_name; //가게이름

    @Enumerated(EnumType.STRING) //배달 정보넘김
    private DeliveryStatus status;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "Comment_id")
    private Comment comment;


    public static Checklist createchecklist(Order order, Food food, Store store, Delivery delivery, Address address)

    {
        Checklist checklist = new Checklist();
        checklist.SetFoodname(food);
        checklist.SetFoodPrice(food);
        checklist.SetStock(order);
        checklist.SetStorename(store);
        checklist.SetStatus(delivery);
        checklist.SetAddress(address);


        return checklist;
    }

    public void SetFoodname(Food food){
        this.food_name = food.getName();
    }

    public void SetFoodPrice(Food food){
        this.price = food.getPrice();
    }

    public void SetAddress(Address address){
        this.address = address;
    }

    public void SetStock(Order order){
        this.stock= order.getStockQuantity();
    }

    public void SetStorename(Store store){
        this.store_name = store.getName();
    }

    public void SetStatus(Delivery delivery) { this.status = delivery.getStatus() ; }

}

