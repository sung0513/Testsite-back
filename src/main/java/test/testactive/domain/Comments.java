package test.testactive.domain;



import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import test.testactive.domain.user.User;

import javax.persistence.*;

@Entity
@Getter

@NoArgsConstructor
public class Comments extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    //고객 주소와 이름을 가져와야한다.
    @ManyToOne
    @JoinColumn(name = "user_id") //외래키생성. many에서만 생성된다.
    private User user;

    @Column
    private String Guest_comment;

    @Column
    private String User_comment;

    @Builder
    public Comments(String Guest_comment, String User_comment) {
        this.Guest_comment = Guest_comment;
        this.User_comment = User_comment;
    }
}
