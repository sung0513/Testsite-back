package com.example.demo.eating;

import com.example.demo.domain.Food;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("K")
public class KFC extends Food {


    private String k_chicken;
    private String k_taste;

}
