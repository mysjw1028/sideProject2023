package site.metacoding.firstapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
    @GetMapping("/categorylistForm/{userId}")
    public String 카테고리리스트(Integer userId) {
        return "category/listForm";
    }

    @GetMapping("/category/updateForm/{userId}")
    public String 카테고리업데이트(Integer userId) {
        return "category/updateForm";
    }

    @GetMapping("/category/writeForm/{userId}")
    public String 카테고리글쓰기(Integer userId) {
        return "category/writeForm";
    }
}
