package test.testactive.web.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import test.testactive.config.auth.dto.SessionUser;
//import test.testactive.domain.user.UserService;
import test.testactive.service.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final FoodService foodService;

    private final HttpSession httpSession;

    private final OrderService orderService;


    @GetMapping("/") //음식들 나열되있다.
    public String index(Model model) {
        model.addAttribute("food", foodService.findAllDesc()); //food정보를 보여줌

        //CustomOAuth2UserService에서 로그인 성공시 세션에 SessionUser를 저장하도록 구성함.
        //즉 로그인 성공시 httpSession.getAttribute("user")에서 값을 가져올수 있다.

        SessionUser user = (SessionUser) httpSession.getAttribute("user"); //세션값을 가져오는 부분

        if (user != null) { // 세션에 저장된 값이 있을때만 model에 userName으로 등록한다.
            //세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태이니 로그인 버튼이 보인다.
            model.addAttribute("userName", user.getName());
        }

        return "index"; //index.mustache로 자동 변환되어 반환한다.
    }

    @GetMapping("posts/mydata") //내 정보 + 주문목록
    public String postsMyData(Model model) {

        SessionUser user = (SessionUser) httpSession.getAttribute("user"); //세션값을 가져오는 부분
        if (user != null) { // 세션에 저장된 값이 있을때만 model에 userName으로 등록한다.
            //세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태이니 로그인 버튼이 보인다.
            model.addAttribute("userName", user.getName());
            model.addAttribute("userEmail", user.getEmail());
            model.addAttribute("userPicture", user.getPicture());
        }

        model.addAttribute("Order", orderService.findAllDesc()); //food정보를 보여줌

        return "mydata-page";
    }


    //  댓글 사이트
    @GetMapping("/posts/Guest/comment")
    public String CommentSaveUser() {
        return "comment";
    }
}
