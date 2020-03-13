package test.testactive.response;

import test.testactive.domain.Delivery;
import test.testactive.domain.DeliveryStatus;
import test.testactive.food.Food;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
//고객한테 현재 배달 상태를 보여준다.
public class DeliveryListResponseDto {
    @Enumerated(EnumType.STRING) // 쿠폰값 넘김
    private DeliveryStatus status;

    public DeliveryListResponseDto(Delivery entity) {
        this.status = entity.getStatus();
    }
}