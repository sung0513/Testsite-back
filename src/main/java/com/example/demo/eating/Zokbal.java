package com.example.demo.eating;

import com.example.demo.domain.Food;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("Z")
public class Zokbal extends Food {

    private String z_zokbal;
    private String z_taste; //빨간맛 꿀맛 마늘맛

}
