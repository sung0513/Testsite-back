package test.testactive.response;

import test.testactive.domain.Address;
import test.testactive.domain.Member;
import test.testactive.food.Food;

import java.time.LocalDateTime;
//status 는 어떻게보여줄까?...
//내주소를 보여줌
public class AddressListResponseDto {
    private String zipcode;
    private String street;
    public AddressListResponseDto(Address entity){

        this.zipcode = entity.getZipcode(); // 주소1
        this.street = entity.getStreet(); // 주소2
    }
}
