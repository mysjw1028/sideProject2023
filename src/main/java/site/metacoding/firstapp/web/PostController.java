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
import site.metacoding.firstapp.domain.comment.CommentDao;
import site.metacoding.firstapp.domain.img.ImgDto;
import site.metacoding.firstapp.domain.love.Love;
import site.metacoding.firstapp.domain.post.Post;
import site.metacoding.firstapp.domain.post.PostDao;
import site.metacoding.firstapp.domain.user.User;
import site.metacoding.firstapp.domain.user.UserDao;
import site.metacoding.firstapp.service.PostService;
import site.metacoding.firstapp.web.dto.CMRespDto;
import site.metacoding.firstapp.web.dto.comment.CommentReadDto;
import site.metacoding.firstapp.web.dto.post.PostDatailDto;
import site.metacoding.firstapp.web.dto.post.PostListDto;
import site.metacoding.firstapp.web.dto.post.PostPagingDto;
import site.metacoding.firstapp.web.dto.post.PostReadDto;
import site.metacoding.firstapp.web.dto.post.PostUpdateRespDto;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final HttpSession session;
    private final PostDao postDao;
    private final UserDao userDao;
    private final CommentDao commentDao;
    private final PostService postService;

    // 1번째 ?page=0&keyword=스프링 -> 프라이머리키가 아니라서 @PathVariable를 걸음
    @GetMapping("/post/listForm/{userId}")
    public String 내블로그(Model model, Integer page, @PathVariable Integer userId, String keyword) { // 0 -> 0, 1->10,
        // 2->20
        if (page == null)
            page = 0;
        int startNum = page * 3; // 1. 수정함 -> 3개씩 보임

        if (keyword == null || keyword.isEmpty()) {
            List<PostListDto> postList = postDao.findAll(startNum, userId);

            PostPagingDto paging = postDao.paging(page, userId, null);// 페이지 호출
            paging.makeBlockInfo(keyword, userId);

            model.addAttribute("postList", postList);
            model.addAttribute("paging", paging);

            return "post/listForm";

        } else {
            // null이 아닐경우 //값에 안담김

            List<PostListDto> postList = postDao.findSearch(userId, keyword, startNum);
            PostPagingDto paging = postDao.paging(page, userId, keyword);// 페이지 호출
            paging.makeBlockInfo(keyword, userId);

            model.addAttribute("postList", postList);
            model.addAttribute("paging", paging);

        }

        return "post/listForm";

    }

    @GetMapping("/post/writeForm/{userId}")
    public String 블로그글쓰기(@PathVariable Integer userId, Model model) {
        List<PostReadDto> postList = postDao.readOnly(userId);
        model.addAttribute("postList", postList);
        return "post/writeForm";
    }

    @PostMapping("/post/write/{userId}")
    public String postinsert(Post post, ImgDto imgDto) {
        imgDto.getPostThumnail();
        post.setPostThumnail(imgDto.getPostThumnail());
        postDao.insert(imgDto);
        return "post/listForm";
    }

    @GetMapping("/post/detailForm/{postId}/{userId}")
    public String 블로그상세보기(@PathVariable Integer postId, @PathVariable Integer userId, Model model) {
        PostDatailDto postDatailDtos = postDao.detailOnly(postId);// 얘를 올려서
        List<CommentReadDto> commentList = commentDao.commentOnly(userId, postId);

        System.out.println("디버그~~~!" + postDatailDtos.getCategoryTitle());
        model.addAttribute("user", userDao.findById(userId));

        model.addAttribute("PostDatailDto", postService.게시글상세보기(postId, userId));

        model.addAttribute("categoryTitle", postDatailDtos);
        model.addAttribute("post", postDao.findById(postId));
        model.addAttribute("love", postDao.findByDetail(postId, userId));
        model.addAttribute("comment", commentList);
        // model.addAttribute("nickName", commentList);

        return "post/detailForm";
    }

    @GetMapping("/post/updateForm/{postId}/{userId}")
    public String 블로그수정(@PathVariable Integer postId, @PathVariable Integer userId, Model model) {
        Post postPS = postDao.findById(postId);
        System.out.println("디버그postPS getPostContent : " + postPS.getPostContent());

        List<PostUpdateRespDto> postList = postDao.updateView(postId, userId);
        model.addAttribute("categoryList", postList);
        model.addAttribute("categoryId", postList);
        model.addAttribute("postThumnail", postList);
        model.addAttribute("post", postPS);

        // postps -> DB에 있는거 들고옴

        return "post/updateForm";
    }

    @PostMapping("/post/update/{postId}/{userId}")
    public String blogupdate(@PathVariable Integer postId, @PathVariable Integer userId, Post post, ImgDto imgDto) {
        Post postPS = postDao.findById(postId); // DB에 있는지 확인
        System.out.println("디버그 " + postPS.getPostThumnail());
        postPS.update(imgDto);// DB에있는 값
        System.out.println("디버그 " + postPS.getPostThumnail());
        // imgDto.getPostThumnail();// 포스트 getter로 받아왔기 때문에 굳이 쓸필요 없다
        // post.setPostThumnail(imgDto.getPostThumnail());// 이미지 넣기
        postDao.update(imgDto);// 기존에 있던값 변경 & 이미지 넣기
        return "post/listForm";
    }

    @PostMapping("/update/{postId}/delete") // 5번 deleteById -> 삭제하기 -> post로 값 삭제
    public String 삭제하기(@PathVariable Integer postId) {
        Post postPS = postDao.findById(postId);
        postDao.deleteById(postId);
        return "redirect:/";
    }

    // 좋아요 부분
    @PostMapping("/post/{postId}/loves")
    public @ResponseBody CMRespDto<?> insertLoves(@PathVariable Integer postId) {
        User principal = (User) session.getAttribute("principal");
        Love love = new Love(principal.getUserId(), postId);
        postService.좋아요(love);// 이제 프라이머리 키가있어서 응답
        // model.addAttribute("love", love);

        return new CMRespDto<>(1, "좋아요 성공", love);
    }

    // 인증필요 ->세션에 값이 있는지 이사람의 정보가 있는지-> principal 활용
    @DeleteMapping("/post/{postId}/loves/{loveId}") // 충돌나서 lovesId
    public @ResponseBody CMRespDto<?> deleteLoves(@PathVariable Integer postId, @PathVariable Integer loveId) {
        postService.좋아요취소(loveId);
        // System.out.println("디버그!!!!!! : " + loveId);
        return new CMRespDto<>(1, "좋아요 취소 성공", null);
    }

}