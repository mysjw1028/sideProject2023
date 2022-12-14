package site.metacoding.firstapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.category.Category;
import site.metacoding.firstapp.domain.category.CategoryDao;

@RequiredArgsConstructor
@Controller
public class CategoryController {
    private final CategoryDao categoryDao;

    @GetMapping("/categorylistForm/{userId}")
    public String 카테고리리스트(Integer userId) {
        return "category/listForm";
    }

    @GetMapping("/updateForm/{userId}")
    public String 카테고리업데이트(Integer userId) {
        return "category/updateForm";
    }

    @GetMapping("/category/writeForm/{userId}")
    public String 카테고리글쓰기(Integer userId) {
        return "category/writeForm";
    }

    @PostMapping("/category/writeForm/{userId}")
    public String categoryinsert(Category category) {
        categoryDao.insert(category);
        return "redirect:/";// 해당사용자의 키값만 그 사람만 영역만
    }
}
