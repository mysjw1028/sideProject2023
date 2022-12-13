package site.metacoding.firstapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {

    @GetMapping("/categorylistForm")
    public String 카테고리리스트() {
        return "category/listForm";
    }

    @GetMapping("/category/updateForm")
    public String 카테고리업데이트() {
        return "category/updateForm";
    }

    @GetMapping("/category/writeForm")
    public String 카테고리글쓰기() {
        return "category/writeForm";
    }

    @GetMapping("/subscribe/listForm")
    public String 구독관리() {
        return "subscribe/listForm";
    }

    @GetMapping("user/updateForm")
    public String 사용자업데이트() {
        return "user/updateForm";
    }

    @GetMapping("user/profileUpdateForm")
    public String 사진업로드() {
        return "user/profileUpdateForm";
    }

    @GetMapping("user/leaveCheckForm")
    public String 계정관리() {
        return "user/leaveCheckForm";
    }

    // post -> 블로그??
    @GetMapping("post/listForm")
    public String 내블로그() {
        return "post/listForm";
    }

    @GetMapping("post/detailForm")
    public String 블로그상세보기() {
        return "post/detailForm";
    }
}
