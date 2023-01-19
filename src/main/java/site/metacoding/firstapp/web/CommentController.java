package site.metacoding.firstapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.comment.Comment;
import site.metacoding.firstapp.domain.comment.CommentDao;

@RequiredArgsConstructor
@Controller
public class CommentController {
    private final CommentDao commentDao;

    // // 댓글달기 -> comment
    // @GetMapping("/post/writeForm/{userId}")
    // public String 댓글쓰기(@PathVariable Integer userId, Model model) {
    // Comment commenttList = commentDao.replyDetail(userId);
    // model.addAttribute("commenttList", commenttList);
    // return "post/writeForm";
    // } -> 테스트
    // 댓글쓰기 업로드
    @PostMapping("/post/comment/write/{userId}")
    public String replylnsert(Comment comment, Integer userId) {
        commentDao.insert(comment);
        return "post/detailForm";
    }

}
