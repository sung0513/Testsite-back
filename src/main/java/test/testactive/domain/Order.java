package test.testactive.domain;


import lombok.Getter;
import lombok.Setter;
import test.testactive.exeception.NotEnoughStockException;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
@Table(name = "orders")
public class Order {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL )
    private List<Orderfood> orderfoods = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    private int stockQuantity;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public void setMember(Member member) {
        this.member = member;
        member.getOrder().add(this);
    }

    public void addOrderFood(Orderfood orderfood) {
        orderfoods.add(orderfood);
        orderfood.setOrder(this);


    }
    public void SetDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
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
        order.setStatus(DeliveryStatus.READY);
        order.setOrderDate(LocalDateTime.now());
        return order;
    }
    //주문을 생성하려고 할 때 필요한 부분을 활용 할때 이용하는 부분

    /**
     * 주문 하는 경우에 취소 상태를 보여줍니당
    */

    public  void cancel() {
        if(delivery.getStatus() == DeliveryStatus.ARRIVE) {
            throw new IllegalStateException("출발은 상태에서는 취소 하실 수" +
                    "없습니다.");
        }  // 1순위 예외처리 변경

        this.setStatus(DeliveryStatus.CANCEL);
        for(Orderfood orderfood : orderfoods) {
            orderfood.cancel();
        }
        return;
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

