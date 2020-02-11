package testbook.testsite.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String street;
    private String zipcode;

    protected Address() {

    }
    public Address(String street, String zipcode) {
        this.street =street;
        this.zipcode =zipcode;

    }
}
