package test.testactive.domain;


import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Address {

    private String zipcode;
    private String street;

    protected Address() {

    }

    public Address(String zipcode, String street) {
        this.zipcode = zipcode;
        this.street = street;
    }
}
