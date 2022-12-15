package site.metacoding.firstapp.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.post.Post;
import site.metacoding.firstapp.domain.post.PostDao;
import site.metacoding.firstapp.domain.user.User;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostDao postDao;
    private final HttpSession session;

    @GetMapping("/post/listForm/{userId}")
    public String 내블로그() {
        return "post/listForm";
    }

    @GetMapping("/post/writeForm/{userId}")
    public String 블로그글쓰기(Model model) {
        
        List<Post> postList = postDao.readOnly();
        model.addAttribute("post", postList);
        return "post/writeForm";
    }

    public String 블로그상세보기() {
        return "post/detailForm";
    }
}