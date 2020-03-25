package com.example.demo.web.Request;

import com.example.demo.domain.Comments;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
//댓글 저장  -> comment페이지
public class CommentSaveRequestDto {
    private String User_comment;
    private String Guest_comment;

    @Builder
    public CommentSaveRequestDto(String User_comment, String Guest_comment) {
        this.User_comment = User_comment;
        this.Guest_comment = Guest_comment;
    }

    public Comments toEntity() {
        return Comments.builder()
                .User_comment(User_comment)
                .Guest_comment(Guest_comment)
                .build();
    }

}