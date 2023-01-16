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
    public String 메인페이지(Model model) {

        List<Post> postList = postDao.findAllMain();

        model.addAttribute("post", postList);
        model.addAttribute("postList", postList);
        model.addAttribute("nickName", postList);
        model.addAttribute("postThumnail", postList);
        return "mainForm";
    }
}
