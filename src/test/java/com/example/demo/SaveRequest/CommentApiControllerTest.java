package com.example.demo.SaveRequest;


import com.example.demo.domain.Comments;
import com.example.demo.repository.CommentRepository;
import com.example.demo.service.CommentService;
import com.example.demo.web.Request.CommentSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //롤백이안됨

public class CommentApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentService commentService;


//    @After
//    public void tearDown() throws Exception{
//        commentRepository.deleteAll();
//    }
//

    @Test
    public void comment_등록된다() throws Exception {

        //given
        String guest_comment = "def";
        String user_comment = "abc";
        CommentSaveRequestDto requestDto = CommentSaveRequestDto.builder()
                .Guest_comment(guest_comment)
                .User_comment(user_comment)
                .build(); //값을 1차캐시에 넣는다. 마치 em.persist?


        commentService.save(requestDto); //DB에 저장한다.

        String url = "http://localhost:" + port + "/Guest/comment";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        //본래 get으로 값을 불러올때 1차캐시에서 우선적으로 찾는 것으로 알고있다
        //하지만 save로 db에 값을 쑤셔넣어야지만 찾을 수 있다. 왜그러지?
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Comments> all = commentRepository.findAll();
        assertThat(all.get(0).getGuest_comment()).isEqualTo(guest_comment);

    }
}

