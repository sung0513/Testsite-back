package test.testactive.web.Response;

import lombok.Getter;
import test.testactive.food.Food;

@Getter
public class FoodListResponseDto {


    private Long id;
    private String name;
    private int price;

    //전부다 뿌려줌.
    public FoodListResponseDto(Food entity){
        this.id = entity.getId();
        this.name = entity.getName(); // 푸드이름
        this.price = entity.getPrice(); // 가격
    }
}
