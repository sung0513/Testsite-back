package test.testactive.domain;


import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter

@NoArgsConstructor
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column
    private String Guest_comment;

    @Column
    private String User_comment;

    @Builder
    public Comment(String Guest_comment, String User_comment) {
        this.Guest_comment = Guest_comment;
        this.User_comment = User_comment;
    }
}
