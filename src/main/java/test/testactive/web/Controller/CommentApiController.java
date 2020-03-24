package test.testactive.web.Controller;



import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test.testactive.repository.CommentRepository;

import test.testactive.service.CommentService;
import test.testactive.web.request.CommentSaveRequestDto;

@RequiredArgsConstructor
@RestController
public class CommentApiController {

        private final CommentService commentService;
        private final CommentRepository commentRepository;
        //아작스통신으로 값을 넘겨줘서 저장.
        @PostMapping("/Guest/comment") //guest 댓글을 저장함
        public Long save(@RequestBody CommentSaveRequestDto requestDto){
            return commentService.save(requestDto);
        }

        @PostMapping("/Chairman/comment") //사장 댓글을 저장함
        public Long saveChairman(@RequestBody CommentSaveRequestDto requestDto){
            return commentService.save(requestDto);
        }
}

//test