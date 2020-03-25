package com.example.demo.service;

import com.example.demo.domain.Comments;
import com.example.demo.repository.CommentRepository;
import com.example.demo.web.Request.CommentSaveRequestDto;
import com.example.demo.web.Update.CommentUpdateRequestDto;
import com.example.demo.web.Response.CommentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Long save(CommentSaveRequestDto requestDto) {
        return commentRepository.save(requestDto.toEntity()).getId(); //바로 db에저장된다!

    }

    //수정하기
    public Long update(Long id, CommentUpdateRequestDto requestDto){
        Comments comments = commentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("글이 없습니다. id="+ id));
            comments.update(requestDto.getGuest_comment(), requestDto.getUser_comment());
            return id;
    }

    //띄우기
    public CommentResponseDto findById(Long id){
        Comments entity = commentRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("글이 없습니다. id="+ id));

        return new CommentResponseDto(entity);
    }

}
