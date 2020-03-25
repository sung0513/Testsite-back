package com.example.demo.web.Response;

import com.example.demo.domain.Comments;
import lombok.Builder;


//작성정보를 보여줌
public class CommentResponseDto {
    private Long id;
    private String User_comment;
    private String Guest_comment;

    @Builder
    public CommentResponseDto(Comments entity) {
        this.id = entity.getId();
        this.Guest_comment = entity.getGuest_comment();
        this.User_comment = entity.getUser_comment();
    }

    public Comments toEntity() {
        return Comments.builder()
                .User_comment(User_comment)
                .Guest_comment(Guest_comment)
                .build();
    }
}
