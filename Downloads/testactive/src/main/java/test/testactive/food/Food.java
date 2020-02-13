package test.testactive.food;


import lombok.Getter;
import lombok.Setter;
import test.testactive.domain.Category;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="Ftype")
@Getter@Setter
public  abstract class Food {


    @Id@GeneratedValue
    @Column(name = "food_id")
    private Long id;

    private String name;
    private int price;

    @ManyToMany(mappedBy = "foods")
    private List<Category> categories  = new ArrayList();





}
