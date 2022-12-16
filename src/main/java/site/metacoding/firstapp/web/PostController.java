package site.metacoding.firstapp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.post.Post;
import site.metacoding.firstapp.domain.post.PostDao;
import site.metacoding.firstapp.web.dto.post.PostReadDto;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostDao postDao;

    @GetMapping("/post/listForm/{userId}")
    public String 내블로그(Model model) {
        List<Post> postList = postDao.findAll();
        System.out.println("디버그  1111111111:" + postDao.findAll());
        for (Post post : postList) {
            String s = post.getPostTitle();
            System.out.println("디버그    " + s);
        }
        model.addAttribute("postList", postList);
        System.out.println("디버그  22222222222222:" + postDao.findAll());
        return "post/listForm";
    }

    @GetMapping("/post/writeForm/{userId}")
    public String 블로그글쓰기(Model model) {
        List<PostReadDto> postList = postDao.readOnly();
        model.addAttribute("postList", postList);
        return "post/writeForm";
    }

    @PostMapping("/post/write/{userId}")
    public String postinsert(Post post) {
        postDao.insert(post);
        return "redirect:/";
    }

    @GetMapping("/post/detailForm/{userId}")
    public String 블로그상세보기() {
        return "post/detailForm";
    }
}