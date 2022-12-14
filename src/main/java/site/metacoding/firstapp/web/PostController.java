package site.metacoding.firstapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
    @GetMapping("/post/listForm/{userId}")
    public String 내블로그(Integer userId) {
        return "post/listForm";
    }

    @GetMapping("/post/writeForm/{userId}")
    public String 블로그글쓰기(Integer userId) {
        return "/post/writeForm";
    }

    @GetMapping("/post/detailForm")
    public String 블로그상세보기() {
        return "post/detailForm";
    }
}
