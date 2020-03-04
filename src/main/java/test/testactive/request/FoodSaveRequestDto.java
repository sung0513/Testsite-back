package test.testactive.request;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import test.testactive.food.Food;


@Getter
@NoArgsConstructor


//고객이 웹에서 입력 받아 저장하는 클래스

public class FoodSaveRequestDto {
    private Long id;
    private String name;
    private int price;

    @Builder

    public FoodSaveRequestDto(String name, int price) {
        this.name = name;
        this.price = price;
    }





    public Food toEntity() {
        return Food.builder()
                .id(id)
                .name(name) //비비큐
                .price(price) // 180000
                .build();
    }

}
