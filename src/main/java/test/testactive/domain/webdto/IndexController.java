package test.testactive.domain.webdto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index"; //index.mustache로 자동 변환되어 반환한다.
    }

    @GetMapping("posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
