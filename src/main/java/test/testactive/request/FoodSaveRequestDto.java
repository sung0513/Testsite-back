package test.testactive.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import test.testactive.food.Food;


@Getter
@NoArgsConstructor
//웹에서 입력 받아 저장하는 클래스
public class FoodSaveRequestDto {
    private String name;
    private int price;

    @Builder
    public FoodSaveRequestDto(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Food toEntity() {
        return Food.builder()
                .name(name)
                .price(price)
                .build();
    }

}
