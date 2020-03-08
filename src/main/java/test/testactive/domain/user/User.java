package test.testactive.domain.user;

import lombok.*;
import test.testactive.domain.BaseTimeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;

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
