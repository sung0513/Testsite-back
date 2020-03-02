package test.testactive.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Embeddable //H2 디비
@Getter
@Setter

//고객 주소입력
public class Address {


    private String zipcode;
    private String street;

    public Address() {

    }

    @Builder
    public Address(String zipcode, String street) {
        this.zipcode = zipcode;
        this.street = street;
    }

}
