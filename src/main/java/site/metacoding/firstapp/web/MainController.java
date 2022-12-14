package site.metacoding.firstapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping({ "/", "/mainForm" }) // 화면 출력되는지 확인 완료
    public String 메인페이지() {
        return "mainForm";
    }

}
