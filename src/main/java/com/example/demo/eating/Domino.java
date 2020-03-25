package com.example.demo.eating;

import com.example.demo.domain.Food;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Setter
@DiscriminatorValue("D")
public class Domino extends Food {

    private String d_piiza;
    private String d_taste;

}
