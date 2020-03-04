package test.testactive.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import test.testactive.exeception.NotEnoughStockException;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
@Table(name = "orders")
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

    private LocalDateTime orderDate;

    private int stockQuantity;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
//
//    @OneToOne(mappedBy = "order")
//    private Checklist cheklist;


    public void setMember(Member member) {
        this.member = member; //member값을 입력받는다
        member.getOrder().add(this); //member값을 Oreder을 리스트에 더해준다.
    }

    public void addOrderFood(Orderfood orderfood) {
        orderfoods.add(orderfood); // orderfoods라는 배열에 orderfood 하나의 이름을 저장한다.
        orderfood.setOrder(this);  // orderfood 를 오더에 설정해서 올림.
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

//    @Builder //사용자에게 입력받는 정보 + 사용자에게 해당정보를 보여준다.
//    public Order(int stockQuantity, Delivery status, String address, int s_coupon) {
//        this.name = name;
//        this.tel = tel;
//        this.address = address;
//        this.s_coupon = s_coupon;
//    }

    /**
     * 주문 후에 취소 상태를 보여준다
     */

    public  void cancel() {
        if(delivery.getStatus() == DeliveryStatus.ARRIVE) {
            throw new IllegalStateException("출발은 상태에서는 취소 하실 수" +
                    "없습니다.");
        }
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
    // 장바구니 컨트롤
    public void basket_cancel(int quantity) //+, - 둘다 해당함수 불러옴
    {
        this.stockQuantity += quantity; //취소버튼을 누를경우 -1값이 넘어간다
        if (stockQuantity == 1) {
            throw new NotEnoughStockException("non click sub");
        } else if (stockQuantity >= 100) {
            throw new NotEnoughStockException("non click add");
        }
    }

}

