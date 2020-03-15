package test.testactive.domain;


import lombok.*;

import javax.persistence.*;

@Embeddable //H2 디비
@Getter
@NoArgsConstructor
//고객 주소입력
public class Address {

    String zipcode;
    String street;


    @Builder
    public Address(String zipcode, String street) {
        this.zipcode = zipcode;
        this.street = street;
    }

}
