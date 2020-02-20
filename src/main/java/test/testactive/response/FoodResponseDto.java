package test.testactive.response;

import test.testactive.food.Food;
import test.testactive.repository.FoodRepository;

//응답용
public class FoodResponseDto {
    private Long id;
    private String name;
    private int price;

    public FoodResponseDto(Food entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();

    }
}
