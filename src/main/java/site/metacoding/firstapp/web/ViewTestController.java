package site.metacoding.firstapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {



    @GetMapping({ "/", "/mainForm" }) // 화면 출력되는지 확인 완료
    public String 메인페이지() {
        return "mainForm";
    }

    @GetMapping("/categorylistForm") // 화면 출력되는지 확인 완료
    public String 카테고리리스트() {
        return "category/listForm";
    }

    @GetMapping("/category/updateForm") // 화면 출력되는지 확인 완료
    public String 카테고리업데이트() {
        return "category/updateForm";
    }

    @GetMapping("/category/writeForm") // 화면 출력되는지 확인 완료
    public String 카테고리글쓰기() {
        return "category/writeForm";
    }
}
