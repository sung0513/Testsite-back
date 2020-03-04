package test.testactive.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Embeddable //H2 디비
@Getter
@Setter
@RequiredArgsConstructor
//고객 주소입력
public class Address {

    private Long id;
    private String zipcode;
    private String street;

    @Builder
    public Address(Long id, String zipcode, String street) {
        this.id = id;
        this.zipcode = zipcode;
        this.street = street;
    }

}
