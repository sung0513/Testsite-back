package test.testactive.web.Response;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import test.testactive.domain.Delivery;
import test.testactive.domain.DeliveryStatus;
import test.testactive.domain.Member;
import test.testactive.domain.Order;
import test.testactive.food.Food;
import test.testactive.service.OrderService;

import java.util.ArrayList;
import java.util.List;


@Getter
public class OrderListResponseDto {

    @Autowired
    OrderService orderService;

    private Member member;
    private DeliveryStatus status;
    private int stockQuantity;
    private Delivery delivery;
    private List<Food> food = new ArrayList<>();

    public OrderListResponseDto(Order entity){
        this.member = entity.getMember();
        this.status = entity.getStatus();
        this.stockQuantity=entity.getStockQuantity();
        this.food = entity.getFood();

    }
}
