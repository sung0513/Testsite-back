package test.testactive.web.Update;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class CommentUpdateRequest {

    private String User_comment;
    private String Guest_comment;

    @Builder
    public void CommentUpdateRequestDto(String user_comment, String guest_comment) {
        User_comment = user_comment;
        Guest_comment = guest_comment;
    }
}
