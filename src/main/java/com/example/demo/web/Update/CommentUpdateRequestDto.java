package com.example.demo.web.Update;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

//작성정보 업데이트
public class CommentUpdateRequestDto {
    private String User_comment;
    private String Guest_comment;

    @Builder
    public CommentUpdateRequestDto(String user_comment, String guest_comment) {
        User_comment = user_comment;
        Guest_comment = guest_comment;
    }
}
