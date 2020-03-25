package com.example.demo.web.Controller;

import com.example.demo.domain.*;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderApiController {
    private final OrderService orderService;
    private final ChecklistService checklistService;
    @PostMapping("/Order/Save") //결재 완료 클릭시 주문정보 저장.
    public Long save(@RequestBody Member member, @RequestBody Food food, @RequestBody Store store, @RequestBody Order order, @RequestBody Delivery delivery, int stock)
           {
        checklistService.Check(member.getId(), food.getId(), store.getId(),order.getId(),delivery.getId());
        return  orderService.order(member.getId(), food.getId(), stock); //프론트에 값을 받아야한다.

    }


    @PostMapping("/Order/Cancle") // 취소 버튼클릭시 주문취소 //checklist 에서 맨위에것을 가져와야한다.
    public void Cancle(@RequestBody Order order, @RequestBody Food food, @RequestBody Store store){
        orderService.cancelOrder(order.getId(), food.getId(), store.getId());
    }

}
