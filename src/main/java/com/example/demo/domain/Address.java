package com.example.demo.domain;

import lombok.*;


import javax.persistence.*;

@Embeddable //H2 디비
@Getter
@NoArgsConstructor
public class Address {

    @Column(name = "zipcode")
    String zipcode;
    @Column(name = "street")
    String street;


    @Builder
    public Address(String zipcode, String street) {
        this.zipcode = zipcode;
        this.street = street;

    }
}
