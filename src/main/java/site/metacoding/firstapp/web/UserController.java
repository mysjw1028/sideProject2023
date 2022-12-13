package site.metacoding.firstapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user/joinForm") // 화면 출력되는지 확인 완료
    public String 회원가입페이지() {
        return "user/joinForm";
    }

}
