package test.testactive.service;

import lombok.NoArgsConstructor;
import test.testactive.domain.Comment;
import test.testactive.domain.Member;
import test.testactive.domain.user.Role;
import test.testactive.domain.user.User;
import test.testactive.repository.CommentRepository;
import test.testactive.repository.MemberRepository;
import test.testactive.repository.UserRepository;

import java.util.List;

@NoArgsConstructor
public class CommentService {

     CommentRepository commentRepository;
     UserRepository userRepository;


    private void DiscriminateLevel(Comment comment) {
        User user = userRepository.findOne(1L); //어떻게 id값을 가져올 것 인가?
        if(user.getRole() == Role.GUEST) //손님일경우 접근 불가능.
            else //접근 가능

        }
    }
}


