package com.example.demo.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Category extends BaseTimeEntity {

    @Id // pk키 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Column(name = "category_id") //컬럼네임
    private Long id;


    @Column(name ="category_name" )
    private String name;



    @ManyToMany // n:n 매핑
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"), // 해당컬럼 id와 조인
            inverseJoinColumns = @JoinColumn(name = "food_id"))
    private List<Food> foods = new ArrayList(); //food 카테고리의 목록을 저장하는 list

    @ManyToOne // n:1 매핑
    @JoinColumn(name = "parent_id") //db명
    private Category parent;


    @OneToMany(mappedBy = "parent") //1:n Owner = One컬럼 부여
    private List<Category> categories = new ArrayList<>();


    @OneToMany(mappedBy = "parent") // 1:n Owner = One컬럼 부여
    private List<Category> child = new ArrayList<>();



    public Category Insert_Child_value(Category parent){
        return this.parent = parent;
    }

    public void addChildCategory(Category child) {
        this.child.add(child);
        Insert_Child_value(this);
    }

}



