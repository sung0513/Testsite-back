package test.testactive.domain;


import lombok.Getter;
import lombok.Setter;
import test.testactive.food.Food;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter

public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_id")

    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item",
            joinColumns =@JoinColumn(name = "category_id"),
            inverseJoinColumns =@JoinColumn(name = "food_id"))
    private List<Food> foods = new ArrayList();

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> categories = new ArrayList<>();


}

