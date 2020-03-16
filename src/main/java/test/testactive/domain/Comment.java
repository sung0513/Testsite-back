package test.testactive.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name="Comment")
public class Comment extends BaseTimeEntity {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Comment_id")
    private  Long id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "comment", fetch = FetchType.LAZY)
    private Checklist checklist;

    private String title;

    private String post;

    @Builder
    public Comment(Long id, Checklist checklist, String title, String post) {
        this.id = id;
        this.checklist = checklist;
        this.title = title;
        this.post = post;
    }


}
