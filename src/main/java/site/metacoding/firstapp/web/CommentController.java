package site.metacoding.firstapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CommentController {

    // 댓글달기 -> comment
    @PostMapping("/post/comment/write/{userId}")
    public String commentinsert() {

        return "post/listForm";
    }
}
