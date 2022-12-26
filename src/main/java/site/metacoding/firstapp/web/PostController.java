package site.metacoding.firstapp.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
        for (Post post : postList) {
            String s = post.getPostTitle();
            System.out.println("디버그    " + s);
        }
        model.addAttribute("postList", postList);
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
    public String blogupdate(@PathVariable Integer postId, @PathVariable Integer userId, Post post,
            @PathVariable MultipartFile file) {

        System.out.println("디버그 getCategoryId  : " + post.getCategoryId());

        Post postPS = postDao.findById(postId);
        postPS.update(post);
        postDao.update(postPS);

        String fileName = file.getOriginalFilename();
        System.out.println("fileName : " + fileName);
        // 사진을 받았는데, file을 받았는데 (DB에 넣을지, 서버 하드디스크에 기록할 지!!)
        String filePath = "C:\\Users\\mysjw\\OneDrive\\사진\\upload\\" + fileName;
        System.out.println("filePath : " + filePath);

        File dest = new File(filePath);
        try {
            Files.copy(file.getInputStream(), dest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    // @GetMapping("/uploadhome")
    // public String index() {
    // return "test";
    // }

    // @PostMapping("/upload")
    // public @ResponseBody String create(@RequestPart MultipartFile file) {
    // String fileName = file.getOriginalFilename();
    // System.out.println("fileName : " + fileName);
    // // 사진을 받았는데, file을 받았는데 (DB에 넣을지, 서버 하드디스크에 기록할 지!!)
    // String filePath = "C:\\Users\\mysjw\\OneDrive\\사진\\upload\\" + fileName;
    // System.out.println("filePath : " + filePath);

    // File dest = new File(filePath);
    // try {
    // Files.copy(file.getInputStream(), dest.toPath());
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // return "ok";
    // }

}
