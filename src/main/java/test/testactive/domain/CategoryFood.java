package test.testactive.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import test.testactive.food.Food;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class CategoryFood {


    @Id@GeneratedValue
    @Column(name = "CategoryFood_id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    @Builder
    public CategoryFood(Long id, Food food, Category category) {
        this.id = id;
        this.food = food;
        this.category = category;
    }

}
