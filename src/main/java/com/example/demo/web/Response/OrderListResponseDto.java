package com.example.demo.web.Response;


import com.example.demo.domain.*;

import java.util.ArrayList;
import java.util.List;

public class OrderListResponseDto {

        private Member member;
        private List<Orderfood> orderfoods = new ArrayList<>();
        private DeliveryStatus status;
        private int stockQuantity;
        private Delivery delivery;
        private List<Food> food = new ArrayList<>();

//    public ChecklistListResponseDto(Checklist entity){
//        this.member = entity.g
//    }

}
