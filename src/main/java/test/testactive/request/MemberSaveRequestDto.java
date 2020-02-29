package test.testactive.request;

import lombok.Builder;
import test.testactive.domain.Address;
import test.testactive.food.Food;

public class MemberSaveRequestDto {

    private String zipcode;
    private String street;


    @Builder
    public MemberSaveRequestDto(String zipcode, String street) {
        this.zipcode = zipcode;
        this.street = street;
    }


    public Address toEntity() {
        return Address.builder()
                .zipcode(zipcode)
                .street(street)
                .build();
    }
}
