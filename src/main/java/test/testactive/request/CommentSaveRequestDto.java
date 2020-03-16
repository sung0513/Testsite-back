package test.testactive.request;

import lombok.Builder;
import test.testactive.domain.Comment;
import test.testactive.domain.user.User;
import test.testactive.food.Food;

public class CommentSaveRequestDto {

    private String User_comment;
    private String Guest_comment;

    @Builder
    public CommentSaveRequestDto(String User_comment, String Guest_comment) {
        this.User_comment = User_comment;
        this.Guest_comment = Guest_comment;
    }

    public Comment toEntity() {
        return Comment.builder()
                .User_comment(User_comment)
                .Guest_comment(Guest_comment)
                .build();
    }
}
