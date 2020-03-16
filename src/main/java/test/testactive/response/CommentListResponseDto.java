package test.testactive.response;

import lombok.Getter;
import test.testactive.domain.Comment;
import test.testactive.food.Food;

import java.time.LocalDateTime;

@Getter
public class CommentListResponseDto {
        private String User_comment;
        private String Guest_comment;

        public CommentListResponseDto(Comment entity){
            this.User_comment = entity.getUser_comment();
            this.Guest_comment = entity.getGuest_comment();
        }

}

