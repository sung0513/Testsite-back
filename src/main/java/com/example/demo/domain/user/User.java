package com.example.demo.domain.user;

import com.example.demo.domain.BaseTimeEntity;
import com.example.demo.domain.Comments;
import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//구글 or 네이버 로그인시 DB 엔티티생성
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //파라미터가없는 기본생성자를 만들어주는 어노테이션.
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 키 && auto 사용
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String email;

    @Column
    private String picture;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Comments> comment = new ArrayList<>();


    @Enumerated(EnumType.STRING) //db에 저장시 이넘값을 어떤형태로 저장할지 결정한다. default ; int
    @Column(nullable = false)
    private Role role;

    @Builder
    private User(String name, String email, String picture, Role role){

        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
        }
}
