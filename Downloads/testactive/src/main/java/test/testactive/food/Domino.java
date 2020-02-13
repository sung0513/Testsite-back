package test.testactive.food;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Setter@Getter
@DiscriminatorValue("D")
public class Domino extends Food {

    private String d_piiza;
    private String d_taste;


}
