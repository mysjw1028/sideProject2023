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

    @GetMapping("/category/updateForm/{userId}")
    public String 카테고리업데이트() {
        return "category/updateForm";
    }

    @PostMapping("/category/updateForm/{userId}")
    public String categoryupdate(@PathVariable Integer categoryId, Category category) {
        Category categoryPS = categoryDao.findById(categoryId);
        categoryPS.update(category);
        categoryDao.update(categoryPS);
        return "redirect:/";
    }

    @GetMapping("/category/writeForm/{userId}")
    public String 카테고리글쓰기() {
        return "category/writeForm";
    }

    @PostMapping("/category/writeForm/{userId}")
    public String categoryinsert(Category category) {
        categoryDao.insert(category);
        return "redirect:/";
    }
}
