package test.testactive.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import test.testactive.config.auth.LoginUser;
import test.testactive.config.auth.dto.SessionUser;
import test.testactive.domain.Order;
import test.testactive.domain.Store;
import test.testactive.domain.user.User;
import test.testactive.domain.user.UserDto;
import test.testactive.domain.user.UserService;
import test.testactive.repository.OrderRepository;
import test.testactive.request.StoreSaveRequestDto;
import test.testactive.service.FoodService;
import test.testactive.service.MemberService;
import test.testactive.service.OrderService;
import test.testactive.service.StoreService;

import javax.servlet.http.HttpSession;
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final FoodService foodService;
    private final StoreService storeService;
    private final OrderService orderService;
    private final MemberService memberService;
    private final HttpSession httpSession;
    private final UserService userService;


    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("food", foodService.findAllDesc());

        //CustomOAuth2UserService에서 로그인 성공시 세션에 SessionUser를 저장하도록 구성함.
        //즉 로그인 성공시 httpSession.getAttribute("user")에서 값을 가져올수 있다.
//        SessionUser user = (SessionUser) httpSession.getAttribute("user"); //세션값을 가져오는 부분

        if (user != null){ // 세션에 저장된 값이 있을때만 model에 userName으로 등록한다.
            //세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태이니 로그인 버튼이 보인다.
            model.addAttribute("userName",user.getName());
        }

        return "index"; //index.mustache로 자동 변환되어 반환한다.
    }
//
//    @GetMapping("/barket") //결과를 전송
//    public String barket(Model model) {
//
//        model.addAttribute("Food", foodService.b_findFoods()); //음식이름, 가격
//        model.addAttribute("Store", storeService.b_findStores()); //가게이름,전화번호
////        model.addAttribute("Order", orderService.b_findOrders()); //배달상태
//        model.addAttribute("member",memberService.b_findMembers());
//
//        return "barket";
//    }

//
//
//    @GetMapping("/user/signup")
//    public String dispSignup() {
//        return "/signup";
//    }
//
//
//
//    // 회원가입 처리
//    @PostMapping("/user/signup")
//    public String execSignup(UserDto userDto) {
//        userService.joinUser(userDto);
//
//        return "redirect:/user/login";
//    }
//
//    // 로그인 페이지
//    @GetMapping("/user/login")
//    public String dispLogin() {
//        return "/login";
//    }
//
//    // 로그인 결과 페이지
//    @GetMapping("/user/login/result")
//    public String dispLoginResult() {
//        return "/loginSuccess";
//    }
//
//    // 로그아웃 결과 페이지
//    @GetMapping("/user/logout/result")
//    public String dispLogout() {
//        return "/logout";
//    }
//
//    // 접근 거부 페이지
//    @GetMapping("/user/denied")
//    public String dispDenied() {
//        return "/denied";
//    }
//
//    // 내 정보 페이지
//    @GetMapping("/user/info")
//    public String dispMyInfo() {
//        return "/myinfo";
//    }
//
//    // 어드민 페이지
//    @GetMapping("/admin")
//    public String dispAdmin() {
//        return "/admin";
//    }
//
//    @GetMapping("posts/save")
//    public String postsSave(){
//        return "posts-save";
//    }
}
