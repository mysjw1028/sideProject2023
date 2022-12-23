package site.metacoding.firstapp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.post.Post;
import site.metacoding.firstapp.domain.post.PostDao;
import site.metacoding.firstapp.web.dto.post.PostReadDto;
import site.metacoding.firstapp.web.dto.post.PostUpdateRespDto;

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

    @GetMapping("/post/detailForm/{postId}/{userId}")
    public String 블로그상세보기(@PathVariable Integer postId, Model model) {
        System.out.println("디버그    " + postDao.findById(postId));
        System.out.println("디버그  " + postId);
        model.addAttribute("post", postDao.findById(postId));
        return "post/detailForm";
    }

    @GetMapping("/post/updateForm/{postId}/{userId}")
    public String 블로그수정(@PathVariable Integer postId, Model model) {
        Post postPS = postDao.findById(postId);
        System.out.println("디버그postPS getPostContent : " + postPS.getPostContent());

        List<PostUpdateRespDto> postList = postDao.updateView(postId);
        model.addAttribute("categoryList", postList);
        model.addAttribute("categoryId", postList);
        model.addAttribute("post", postPS);
        // postps -> DB에 있는거 들고옴

        return "post/updateForm";
    }

    @PostMapping("/post/update/{postId}/{userId}")
    public String blogupdate(@PathVariable Integer postId, @PathVariable Integer userId, Post post) {

        Post postPS = postDao.findById(postId);
        postPS.update(post);
        postDao.update(postPS);

        System.out.println("디버그 postId : " + postId);
        System.out.println("디버그 getPostTitle : " + post.getPostTitle());
        System.out.println("디버그 getPostContent : " + post.getPostContent());
        System.out.println("디버그 getCategoryId  : " + post.getCategoryId());
        System.out.println("디버그 getUserId : " + post.getUserId());

        return "redirect:/";
    }

}
