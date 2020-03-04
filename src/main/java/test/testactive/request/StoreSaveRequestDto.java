package test.testactive.request;


//입력된 푸드정보를 웹에서 가져와서 저장한다.

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import test.testactive.domain.Store;
import test.testactive.food.Food;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
public class StoreSaveRequestDto {
    private String name;
    private String address;
    private String tel;
    private int s_coupon;


    @Builder

    public StoreSaveRequestDto(String name, String address, String tel, int s_coupon) {
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.s_coupon = s_coupon;
    }


    public Store toEntity() {
        return Store.builder()
                .name(name) //비비큐
                .address(address) // 180000
                .tel(tel)
                .s_coupon(s_coupon)
                .build();
    }

}
