package test.testactive.food;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter@Setter
@DiscriminatorValue("Z")
public class Zokbal extends Food {

        private String z_zokbal;
        private String z_taste; //빨간맛 꿀맛 마늘맛

}
