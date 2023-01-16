package site.metacoding.firstapp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.post.Post;
import site.metacoding.firstapp.domain.post.PostDao;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final PostDao postDao;

    @GetMapping({ "/", "/mainForm" }) // 화면 출력되는지 확인 완료
    public String 메인페이지(Model model, String keyword) {
        System.out.println("디버그 : keyword : " + keyword);

        if (keyword == null || keyword.isEmpty()) {
            List<Post> postListsearch = postDao.findSearchMain(null);

            model.addAttribute("post", postListsearch);
            model.addAttribute("postList", postListsearch);
            model.addAttribute("nickName", postListsearch);
            model.addAttribute("postThumnail", postListsearch);
            return "mainForm";
        } else {
            System.out.println("디버그 : keyword : " + keyword);
            List<Post> postListsearch = postDao.findSearchMain(keyword);

            model.addAttribute("post", postListsearch);
            model.addAttribute("postList", postListsearch);
            model.addAttribute("nickName", postListsearch);
            model.addAttribute("postThumnail", postListsearch);
            return "mainForm";
        }
    }
}