package test.testactive.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import test.testactive.domain.Address;


@Getter
@NoArgsConstructor
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
