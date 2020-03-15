package test.testactive.request;

import lombok.Builder;
import test.testactive.domain.Address;


public class AddressSaveRequestDto {

    private String zipcode;
    private String street;


    @Builder
    public AddressSaveRequestDto(String zipcode, String street) {

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
