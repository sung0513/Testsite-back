package testbook.testsite.food;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("O")
public class Onegrand extends Food {

    private Long o_id;
    private String o_name;
}
