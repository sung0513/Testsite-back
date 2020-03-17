package test.testactive.web;

import org.springframework.data.jpa.repository.JpaRepository;
import test.testactive.domain.Comment;

public interface TestRepository extends JpaRepository<Comment, Long> {

}
