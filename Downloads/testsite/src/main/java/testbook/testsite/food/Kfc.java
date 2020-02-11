package testbook.testsite.food;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Setter@Getter
@DiscriminatorValue("K")
public class Kfc extends Food  {

    private Long k_id;
    private String k_name;
}
