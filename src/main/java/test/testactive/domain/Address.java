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

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "street")
    private String street;

    @Builder
    public Address( String zipcode, String street) {
        this.zipcode = zipcode;
        this.street = street;
    }

}
