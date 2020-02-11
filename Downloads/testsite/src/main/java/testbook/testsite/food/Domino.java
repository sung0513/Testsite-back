package testbook.testsite.food;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter@Setter
@DiscriminatorValue("D")
public class Domino extends Food {

    private Long d_id;
    private String d_anme;

}
