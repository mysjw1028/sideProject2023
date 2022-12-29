package site.metacoding.firstapp.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.category.Category;
import site.metacoding.firstapp.domain.love.Love;
import site.metacoding.firstapp.domain.post.Post;
import site.metacoding.firstapp.domain.post.PostDao;
import site.metacoding.firstapp.domain.user.User;
import site.metacoding.firstapp.service.PostService;
import site.metacoding.firstapp.web.dto.CMRespDto;
import site.metacoding.firstapp.web.dto.post.PostDatailDto;
import site.metacoding.firstapp.web.dto.post.PostReadDto;
import site.metacoding.firstapp.web.dto.post.PostUpdateRespDto;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final HttpSession session;
    private final PostDao postDao;
    private final PostService postService;

    @GetMapping("/post/listForm/{userId}")
    public String 내블로그(@PathVariable Integer userId, Model model) {
        List<Category> categoryTitle = postDao.findAllcategory(userId);
        List<Post> postList = postDao.findAll(userId);
        for (Post post : postList) {
            String s = post.getPostTitle();
            System.out.println("디버그    " + s);
        }
        model.addAttribute("postList", postList);
        model.addAttribute("categoryTitle", categoryTitle);

        return "post/listForm";
    }

    @GetMapping("/post/writeForm/{userId}")
    public String 블로그글쓰기(@PathVariable Integer userId, Model model) {
        List<PostReadDto> postList = postDao.readOnly(userId);
        model.addAttribute("postList", postList);
        return "post/writeForm";
    }

    @PostMapping("/post/write/{userId}")
    public String postinsert(Post post) {
        postDao.insert(post);
        return "redirect:/";
    }

    @GetMapping("/post/detailForm/{postId}/{userId}")
    public String 블로그상세보기(@PathVariable Integer postId, @PathVariable Integer userId, Model model) {
        model.addAttribute("PostDatailDto", postService.게시글상세보기(postId, userId));

        List<PostReadDto> categoryTitle = postDao.readOnly(postId);

        model.addAttribute("categoryTitle", postId);
        model.addAttribute("post", postDao.findById(postId));
        model.addAttribute("love", postDao.findByDetail(postId, userId));
        System.out.println("디버그 ~~~~~~~~ : " + postDao.findAllcategory(userId));
        for (PostReadDto postReadDto : categoryTitle) {
            String s = postReadDto.getCategoryTitle();
            System.out.println("디버그   카테고리 타이틀 " + s);
        }
        return "post/detailForm";
    }

    @GetMapping("/post/updateForm/{postId}/{userId}")
    public String 블로그수정(@PathVariable Integer postId, @PathVariable Integer userId, Model model) {
        Post postPS = postDao.findById(postId);
        System.out.println("디버그postPS getPostContent : " + postPS.getPostContent());

        List<PostUpdateRespDto> postList = postDao.updateView(postId, userId);
        model.addAttribute("categoryList", postList);
        model.addAttribute("categoryId", postList);
        model.addAttribute("post", postPS);
        // postps -> DB에 있는거 들고옴

        return "post/updateForm";
    }

    @PostMapping("/post/update/{postId}/{userId}")
    public String blogupdate(@PathVariable Integer postId, @PathVariable Integer userId, Post post) {

        System.out.println("디버그 getCategoryId  : " + post.getCategoryId());

        Post postPS = postDao.findById(postId);
        postPS.update(post);
        postDao.update(postPS);

        return "redirect:/";
    }

    @PostMapping("/update/{postId}/delete") // 5번 deleteById -> 삭제하기 -> post로 값 삭제
    public String 삭제하기(@PathVariable Integer postId) {
        Post postPS = postDao.findById(postId);
        postDao.deleteById(postId);
        return "redirect:/";
    }

    // 좋아요 부분
    @PostMapping("/post/{postId}/loves")
    public @ResponseBody CMRespDto<?> insertLoves(@PathVariable Integer postId, Model model) {
        User principal = (User) session.getAttribute("principal");
        Love love = new Love(principal.getUserId(), postId);
        postService.좋아요(love);// 이제 프라이머리 키가있어서 응답
        model.addAttribute("love", love);
        return new CMRespDto<>(1, "좋아요 성공", love);
    }

    // 인증필요 ->세션에 값이 있는지 이사람의 정보가 있는지-> principal 활용
    @DeleteMapping("/post/{postId}/loves/{loveId}") // 충돌나서 lovesId
    public @ResponseBody CMRespDto<?> deleteLoves(@PathVariable Integer postId, @PathVariable Integer loveId) {
        postService.좋아요취소(loveId);
        return new CMRespDto<>(1, "좋아요 취소 성공", null);
    }

}
