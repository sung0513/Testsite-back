package test.testactive.web.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import test.testactive.domain.Order;
import test.testactive.service.OrderService;
import test.testactive.web.request.OrderSaveRequestDto;


@RequiredArgsConstructor
public class OrderApiController {

    private final OrderService orderService;



    @PostMapping("/api/Order/Save") //저장
    public Long save(@RequestBody OrderSaveRequestDto requestDto) {
        return orderService.order(requestDto.getOrder().getId(), requestDto.getStockQuantity());

    }



    @PostMapping("/api/Order/Cancle") // 취소
    public void Cancle(@RequestBody Order order){
        orderService.cancelOrder(order.getId());
    }
}
