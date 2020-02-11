package testbook.testsite.food;

import jdk.jfr.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ftype")
public abstract class Food {

    @Id@GeneratedValue
    @Column(name = "food_id")
    private Long id;

    private String name;
    private int price;

    @ManyToMany(mappedBy = "foods")
    private List<Category> categories =new ArrayList<Category>();

}

//abstract -> single table로 사용할 것이기 떄문에 만들어진 정보들을 가져온다.
