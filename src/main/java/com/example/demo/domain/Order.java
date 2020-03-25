package com.example.demo.domain;



import com.example.demo.exception.NotEnoughStockException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor
public class Order extends BaseTimeEntity {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) //member 과 order을 n:1로 매핑시킨다
    @JoinColumn(name = "member_id") //외래키생성. many에서만 생성된다.
    private Member member;


    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL )
    private List<Orderfood> orderfoods = new ArrayList<>();




    /*
      엔티티 Cascade는 엔티티의 상태 변화를 전파시키는 옵션
     단방향 혹은 양방향으로 매핑되어 있는 엔티티에 대해 어느 한쪽 엔티티의 상태(생성 혹은 삭제)가 변경되었을 시
     그에 따른 변화를 바인딩된 엔티티들에게 전파하는 것을 의미.
출처: https://engkimbs.tistory.com/817 [새로비]
     */


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) //
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;


    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<Food> food = new ArrayList<>();


    private int stockQuantity;


    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;


    @Builder
    public Order(int stockQuantity, DeliveryStatus status) {
        this.stockQuantity = stockQuantity;
        this.status = status;
    }




    public void setMember(Member member) {
        this.member = member; //member값을 입력받는다
        member.getOrder().add(this); //member값을 Oreder을 리스트에 더해준다.
    }

    public void addOrderFood(Orderfood orderfood) {
        orderfoods.add(orderfood); // orderfoods라는 배열에 orderfood 하나의 이름을 저장한다.
        orderfood.Recive_Order(this);  // orderfood 를 오더에 설정해서 올림.
    }

    public void User_setQuantity(int set){
        this.stockQuantity = set;
    }


    public void SetDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.DeliverySetOrder(this);
    }


    /**
     *  이거 주문 생성 할때 만드는 것임 만약에 필요한 경우에 새롭게 추가추가
     *  해서 넣기만 하면 ok
     */




    public  static Order createOrder(Member member, Delivery delivery, Orderfood... orderfood)
    {
        Order order = new Order();
        order.setMember(member);
        order.SetDelivery(delivery);

        for(Orderfood orderfoods : orderfood) {
            order.addOrderFood(orderfoods);
        }
        order.SetReady_DeliveryStatus(DeliveryStatus.READY);
        return order;
    }

    //어디서 이값을 보내줄가?
    public void SetReady_DeliveryStatus(DeliveryStatus status){
        this.status = status;
    }
    /**
     * 주문 후에 취소 상태를 보여준다
     */

    public  void cancel() {
        if(delivery.getStatus() == DeliveryStatus.ARRIVE) {
            throw new IllegalStateException("출발은 상태에서는 취소 하실 수" +
                    "없습니다.");
        }
        this.SetCancle_DeliveryStatus(DeliveryStatus.CANCEL);
        for(Orderfood orderfood : orderfoods) {
            orderfood.cancel();
        }
        return;
    }


    public void SetCancle_DeliveryStatus(DeliveryStatus status){
        this.status = status;
    }

    /**
     * 주문 가격 합을 모두 가져와 보여줍니당
     */

    public int getTotalPrice() {
        int totalPrice =0;
        for(Orderfood orderfood : orderfoods) {
            totalPrice +=orderfood.getTotalPrice();
        }

        return totalPrice;

    }

}

