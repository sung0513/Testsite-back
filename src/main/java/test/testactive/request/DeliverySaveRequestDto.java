package test.testactive.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import test.testactive.domain.Delivery;
import test.testactive.domain.DeliveryStatus;
import test.testactive.food.Food;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@NoArgsConstructor

//사장님이 버튼을 눌러 현재 배달상태를 바꾼다.
public class DeliverySaveRequestDto {


    @Enumerated(EnumType.STRING) // 쿠폰값 넘김
    private DeliveryStatus status;

        @Builder
        public DeliverySaveRequestDto(DeliveryStatus status) {
            this.status = status;
        }


        public Delivery toEntity() {
            return Delivery.builder()
                    .status(status)
                    .build();
        }



}

