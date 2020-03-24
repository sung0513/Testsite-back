package test.testactive.web.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import test.testactive.domain.Delivery;
import test.testactive.domain.DeliveryStatus;
import test.testactive.domain.Member;
import test.testactive.domain.Order;

@Getter
@NoArgsConstructor
public class OrderSaveRequestDto {
    private int stockQuantity;
    Order order = new Order();

    @Builder
    public OrderSaveRequestDto(Member member, Delivery delivery, int stockQuantity, DeliveryStatus status){
        order.setMember(member);
        order.SetDelivery(delivery);
        order.SetReady_DeliveryStatus(status);
        this.stockQuantity = stockQuantity;
    }


    public Order toEntity(){
        return Order.builder()
                .delivery(Delivery.builder().build())
                .member(Member.builder().build())
                .status(DeliveryStatus.ARRIVE)
                .stockQuantity(stockQuantity)
                .build();
    }
}
