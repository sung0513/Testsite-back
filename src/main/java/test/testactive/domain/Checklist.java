import lombok.Builder;

package test.testactive.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import test.testactive.domain.*;
import test.testactive.food.Food;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
////주소, 가격, 가게이름
public class Checklist extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long id;
    @Column
    private String food_name;
    @Column
    private String store_name;
    @Column
    private String food_price;
    @Column
    private String store_tel;
    @Column
    //non -sucess
    private DeliveryStatus status;



    @OneToOne(mappedBy = "checklist", fetch = FetchType.LAZY) //oneToMany ; mappedBy = owner, fetch = 지연로딩


//    @Builder
//    public Check(String now_address, String now_price,String now_Storename, String now_Foodname, String now_tel) {
//        this.now_address = now_address;
//        this.now_price = now_price;
//        this.now_Storename = now_Storename;
//        this.now_Foodname = now_Foodname;
//        this.now_tel = now_tel;
//    }
}

//member: member_id, address
//food: name, price
//store : name, tel
//delivery : status
