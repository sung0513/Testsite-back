package test.testactive.response;

import test.testactive.domain.Store;
import test.testactive.food.Food;

import java.time.LocalDateTime;

// 사용자가 입력한 정보를 보여준다.

public class StoreListResponseDto {

    private String name; //이름
    private String address; //주소

    private String tel; //tel
    private int s_coupon; // 어떤쿠폰을 사용했는지 보여준다.



    public StoreListResponseDto(Store entity){
        this.name = entity.getName();
        this.address = entity.getAddress(); // 푸드이름 ( 가게이름 )
        this.s_coupon = entity.getS_coupon(); //해당가게에서 어떤쿠폰을 사용했는지 보여주기
        this.tel = entity.getTel(); //전화번호 보여준다
    }
}
