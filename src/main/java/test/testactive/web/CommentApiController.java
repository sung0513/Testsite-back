package test.testactive.web;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test.testactive.request.CommentSaveRequestDto;
import test.testactive.service.CommentService;

@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final CommentService commentService;

    //아작스통신으로 값을 넘겨줘서 저장.
    @PostMapping("/Guest/comment") //댓글을 저장함
    public Long save(@RequestBody CommentSaveRequestDto requestDto){
        return commentService.save(requestDto);
    }
}
