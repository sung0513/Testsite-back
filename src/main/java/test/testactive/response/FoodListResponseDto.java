package test.testactive.response;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import test.testactive.food.Food;

import java.time.LocalDateTime;

@Getter
//사용자에게 주문한 정보를 보여줌.
public class FoodListResponseDto {

    private Long id;
    private String name;
    private int price;
    private LocalDateTime modifiedDate;

    public FoodListResponseDto(Food entity){
        this.id = getId();
        this.name = entity.getName(); // 푸드이름
        this.price = entity.getPrice(); // 가격
    }
}
